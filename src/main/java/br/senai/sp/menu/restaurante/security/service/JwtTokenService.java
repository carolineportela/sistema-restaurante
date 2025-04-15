//package br.senai.sp.menu.restaurante.security.service;
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
//    public String generateToken(UsersDetailsDTO user) {
//        try {
//            var algorithm = Algorithm.HMAC256(this.secret);
//
//            return JWT.create()
//                    .withIssuer(this.issuer)
//                    .withSubject(user.getUser().getUserId().toString())
//                    .withIssuedAt(LocalDateTime.now().toInstant(zoneOffset))
//                    .withExpiresAt(LocalDateTime.now().plusMinutes(this.expiration).toInstant(zoneOffset))
//                    .withPayload(Map.of("user", user.toMap()))
//                    .sign(algorithm);
//
//        } catch (JWTCreationException ex) {
//            throw new AuthenticationTokenCreationException(ex);
//        }
//    }
//
//    public Long getUserId(String token) {
//        try {
//            var algorithm = Algorithm.HMAC256(this.secret);
//
//            String id = JWT.require(algorithm)
//                    .withIssuer(this.issuer)
//                    .build()
//                    .verify(token)
//                    .getSubject();
//
//            return Long.parseLong(id);
//
//        } catch (JWTVerificationException ex) {
//            throw new UnauthorizedException(ex);
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
import java.util.UUID;

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
                    .withSubject(user.getUser().getIdUser().toString()) // UUID como string
                    .withIssuedAt(LocalDateTime.now().toInstant(zoneOffset))
                    .withExpiresAt(LocalDateTime.now().plusMinutes(this.expiration).toInstant(zoneOffset))
                    .withPayload(Map.of("user", user.toMap()))
                    .sign(algorithm);

        } catch (JWTCreationException ex) {
            throw new AuthenticationTokenCreationException(ex);
        }
    }

    // 🔁 Troca o tipo de retorno para UUID
    public UUID getUserId(String token) {
        try {
            var algorithm = Algorithm.HMAC256(this.secret);

            String id = JWT.require(algorithm)
                    .withIssuer(this.issuer)
                    .build()
                    .verify(token)
                    .getSubject();

            return UUID.fromString(id); // ✅ Aqui estava errado: era UUID.parseLong (não existe!)

        } catch (JWTVerificationException ex) {
            throw new UnauthorizedException(ex);
        }
    }
}
