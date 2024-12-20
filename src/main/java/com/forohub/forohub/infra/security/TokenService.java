package com.forohub.forohub.infra.security;


import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.forohub.forohub.domain.usuario.entity.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String secret;

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("ForoHub")
                    .withSubject(usuario.getUsername())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaVencimiento())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException("EL token no puede ser nulo");
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret); // validando firma
            DecodedJWT verifier = JWT.require(algorithm)
                    .withIssuer("ForoHub")
                    .build()
                    .verify(token);

            String subject = verifier.getSubject();
            System.out.println(subject);
            if (subject == null) {
                throw new RuntimeException("Verifier inválido: subject es nulo");
            }
            return subject;

        } catch (JWTVerificationException exception) {
            System.out.println("Error al verificar el token: " + exception.toString());
            throw new RuntimeException("Error al verificar el token", exception);
        }
    }


    private Instant generarFechaVencimiento(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
