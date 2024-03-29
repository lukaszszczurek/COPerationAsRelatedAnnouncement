package com.example.coparasystem.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

    private static final String SECRET_KEY = "6D5A7134743777217A25432A462D4A614E645267556B58703273357538782F41";

     public String extractUsername(String token) {
         return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
         final Claims claims = extractAllClaims(token);
         return claimsResolver.apply(claims);
    }

//    private final TimeZone timeZone = TimeZone.getTimeZone("Europe/Warsaw");
    public String generateToken(UserDetails userDetails){
         return generateToken(new HashMap<>(),userDetails);
    }

    public String generateToken(
            Map<String,Object> extraClaims,
            UserDetails userDetails
    ) {
         return Jwts.builder()
                 .setClaims(extraClaims)
                 .setSubject(userDetails.getUsername())
                 .setIssuedAt(new Date(System.currentTimeMillis()))
                 .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 5))
                 .signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();

    }

    // Is token valid

    public boolean isTokenValid(String token, UserDetails userDetails){
         final  String username = extractUsername(token);
         return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);

    }

    private boolean isTokenExpired(String token) {
         return extractExpiration(token).before(new java.util.Date());
    }

    private Date extractExpiration(String token) {
         return extractClaim(token, Claims::getExpiration);

    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build()
                .parseClaimsJws(token).getBody();
    }

    private @NotNull Key getSignInKey() {
            byte [] keyBytes = SECRET_KEY.getBytes();
            return Keys.hmacShaKeyFor(keyBytes);

    }
}

