/**
 * servico responsavel por gerar e validar tokens JWT
 *
 * utiliza a biblioteca do próprio Spring Security + JWT
 * define um tempo de expiração e assina os tokens com uma chave secreta.
 */

//package br.senai.sp.menu.restaurante.security.service;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import br.senai.sp.menu.restaurante.security.dto.UsersDetailsDTO;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.security.Key;
//import java.util.Date;
//
//@Service
//public class JwtTokenService {
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiration}")
//    private long expiration;
//
//    public String generateToken(UsersDetailsDTO userDetails) {
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + expiration);
//
//        // gera uma chave a partir do segredo
//        Key key = Keys.hmacShaKeyFor(secret.getBytes());
//
//        return Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(now)
//                .setExpiration(expiryDate)
//                .signWith(key, SignatureAlgorithm.HS256)
//                .compact();
//    }
//}

//package br.senai.sp.menu.restaurante.security.service;
//
//
//import br.senai.sp.menu.restaurante.errors.exceptions.AuthenticationTokenCreationException;
//import br.senai.sp.menu.restaurante.errors.exceptions.UnauthorizedException;
//import br.senai.sp.menu.restaurante.security.dto.UsersDetailsDTO;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//import java.util.Map;
//
//@Service
//public class JwtTokenService {
//
//    @Value("${restaurante.jwt.secret}")
//    private String secret;
//
//    @Value("${restaurante.jwt.expiration}")
//    private Long expiration;
//
//    @Value("${restaurante.jwt.issuer}")
//    private String issuer;
//
//    private final ZoneOffset zoneOffset = ZoneOffset.of("-03:00");
//
//    public String generateToken(UsersDetailsDTO userDetails) {
//        try {
//            var algorithm = Algorithm.HMAC256(this.secret);
//            return JWT.create()
//                    .withIssuer(this.issuer)
//                    .withSubject(userDetails.getUser().getUserId().toString())
//                    .withIssuedAt(LocalDateTime.now().toInstant(zoneOffset))
//                    .withExpiresAt(LocalDateTime.now().plusMinutes(this.expiration).toInstant(zoneOffset))
//                    .withPayload(Map.of("user", userDetails.toMap()))
//                    .sign(algorithm);
//        } catch (JWTCreationException e) {
//            throw new AuthenticationTokenCreationException(e);
//        }
//    }
//
//    public Long getUserId(String token) {
//        try {
//            var algorithm = Algorithm.HMAC256(this.secret);
//            String id = JWT.require(algorithm)
//                    .withIssuer(this.issuer)
//                    .build()
//                    .verify(token)
//                    .getSubject();
//            return Long.parseLong(id);
//        } catch (JWTVerificationException e) {
//            throw new UnauthorizedException(e);
//        }
//    }
//}

package br.senai.sp.menu.restaurante.security.service;

import br.senai.sp.menu.restaurante.errors.exceptions.AuthenticationTokenCreationException;
import br.senai.sp.menu.restaurante.errors.exceptions.UnauthorizedException;
import br.senai.sp.menu.restaurante.security.dto.UsersDetailsDTO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

@Service
public class JwtTokenService {

    @Value("${restaurante.jwt.secret}")
    private String secret;

    @Value("${restaurante.jwt.expiration}")
    private Long expiration;

    @Value("${restaurante.jwt.issuer}")
    private String issuer;

    private final ZoneOffset zoneOffset = ZoneOffset.of("-03:00");

    public String generateToken(UsersDetailsDTO user) {
        try {
            var algorithm = Algorithm.HMAC256(this.secret);

            return JWT.create()
                    .withIssuer(this.issuer)
                    .withSubject(user.getUser().getUserId().toString())
                    .withIssuedAt(LocalDateTime.now().toInstant(zoneOffset))
                    .withExpiresAt(LocalDateTime.now().plusMinutes(this.expiration).toInstant(zoneOffset))
                    .withPayload(Map.of("user", user.toMap()))
                    .sign(algorithm);

        } catch (JWTCreationException ex) {
            throw new AuthenticationTokenCreationException(ex);
        }
    }

    public Long getUserId(String token) {
        try {
            var algorithm = Algorithm.HMAC256(this.secret);

            String id = JWT.require(algorithm)
                    .withIssuer(this.issuer)
                    .build()
                    .verify(token)
                    .getSubject();

            return Long.parseLong(id);

        } catch (JWTVerificationException ex) {
            throw new UnauthorizedException(ex);
        }
    }
}
