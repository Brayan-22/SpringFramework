package com.alejandro.restsecurityjwt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

@Component
@Slf4j
public class JwtUtils {

    @Value("${app.jwt.secret}")
    private String secret;
    @Value("${app.jwt.time}")
    private long jwtTimeInDays;



    //Creacion de tokens
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Duration.ofDays(jwtTimeInDays).toMillis()))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //Validar token
    public boolean isTokenValid(String token) {
        try{
            Jwts.parser().setSigningKey(getKey()).build()
                    .parseClaimsJws(token)
                    .getBody();
            return true;
        }catch (Exception e){
            log.error("Erro de token: {}",e.getMessage());
            e.printStackTrace();
            return false;
        }
    }



    //Obtener 1 claim
    public <T> T getClaim(String token, Function<Claims,T> claimsTFunction){
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    //Obtener el username del token
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    //Claims
    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //Firmar token
    public Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
