package ru.deadline.destroers.intellilearn.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import ru.deadline.destroers.intellilearn.entities.User;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JwtUtils {
    private String tokenKey;

    public String generateToken(User user) {
        Date expirationDate= Date.from(ZonedDateTime.now().toInstant());
        return JWT.create()
                .withSubject("User details")
                .withClaim("username", user.getUsername())
                .withClaim("role", user.getRole())
                .withClaim("password", user.getPassword())
                .withIssuedAt(new Date())
                .withExpiresAt(expirationDate)
                .withIssuer("spring-app-IntelliLearn")
                .sign(Algorithm.HMAC256(tokenKey));

    }

    public String validateTokenAndRetrieveUsername(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(tokenKey))
                .withSubject("User details")
                .withIssuer("spring-app-IntelliLearn")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("username").asString();
    }
}
