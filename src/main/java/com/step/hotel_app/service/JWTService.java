package com.step.hotel_app.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JWTService {
    private final String secret = "bheemlaNayakParasuramKaruppuGabbarSinghJerseySalaarDragonKGF";

    private Key getKey(){
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateTokens(String userId){
        return Jwts
                .builder()
                .subject(userId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 360000))
                .signWith(getKey())
                .compact();
    }
}
