package com.example.appjamback.global.security.jwt;

import com.example.appjamback.global.security.dto.TokenResponse;
import com.example.appjamback.global.security.exception.ExpiredJwtException;
import com.example.appjamback.global.security.principle.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public TokenResponse getToken(String accountId) {
        String accessToken = generateToken(accountId, jwtProperties.getAccessExp());
        long currentTimeMillis = System.currentTimeMillis();
        long expirationTime = currentTimeMillis + (jwtProperties.getAccessExp() * 1000);
        return TokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(expirationTime)
                .build();
    }

    private String generateToken(String accountId, long expiration) {
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setSubject(accountId)
                .setHeaderParam("typ", "access")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");
        return parseToken(bearer);
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.replace("Bearer ", "");
        }
        return null;
    }

    public UsernamePasswordAuthenticationToken authorization(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getTokenSubject(String subject) {
        return getTokenBody(subject).getSubject();
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            throw ExpiredJwtException.EXCEPTION;
        }
    }
}
