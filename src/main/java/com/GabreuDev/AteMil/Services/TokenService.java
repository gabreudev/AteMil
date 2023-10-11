package com.GabreuDev.AteMil.Services;

import com.GabreuDev.AteMil.Entities.Corretor;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    public String gerarToken(Corretor usuario) {
        return JWT.create()
                .withIssuer("Correcao")
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getId())
                .withExpiresAt(LocalDateTime.now().plusMinutes(10).toInstant(ZoneOffset.of("-3:00")))
                .sign(Algorithm.HMAC256("secreta"));

    }
}
