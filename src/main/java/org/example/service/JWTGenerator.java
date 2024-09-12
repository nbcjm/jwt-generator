package org.example.service;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JWTGenerator {
    SecretKey key = Jwts.SIG.HS256.key().build();

    Date now = new Date();
    Date expirationTime = new Date(now.getTime() + 3600 * 1000);

    public String createJWT(Map<String, String> claims) {
        String jwt = Jwts.builder().issuer("cjm").subject("authorization").issuedAt(now).expiration(expirationTime).claims(claims).signWith(key).compact();
        return jwt;
    }
}
