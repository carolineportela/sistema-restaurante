/**
 * Serviço responsável por gerar e validar tokens JWT.
 *
 * Utiliza a biblioteca do próprio Spring Security + JWT (io.jsonwebtoken).
 * Define um tempo de expiração e assina os tokens com uma chave secreta.
 */

package br.senai.sp.menu.restaurante.security.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import br.senai.sp.menu.restaurante.security.dto.UsersDetailsDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtTokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(UsersDetailsDTO userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        // gera uma chave a partir do segredo
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
