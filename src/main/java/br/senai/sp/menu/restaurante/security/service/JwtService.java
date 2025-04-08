package br.senai.sp.menu.restaurante.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;


@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.issuer}")
    private String issuer;

    private final ZoneOffset zoneOffset = ZoneOffset.of("-03:00");

    // Gera o token JWT
    public String generateToken(String username) {
        var algorithm = Algorithm.HMAC256(this.secret);

        // Converte o Instant para Date
        Date issuedAt = Date.from(LocalDateTime.now().toInstant(zoneOffset));
        Date expiresAt = Date.from(LocalDateTime.now().plusMinutes(this.expiration).toInstant(zoneOffset));

        return JWT.create()
                .withIssuer(this.issuer)
                .withSubject(username)
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .sign(algorithm);
    }

    // Obtém o nome de usuário do token
    public String getUsernameFromToken(String token) {
        var algorithm = Algorithm.HMAC256(this.secret);
        return JWT.require(algorithm)
                .withIssuer(this.issuer)
                .build()
                .verify(token)
                .getSubject();
    }
}