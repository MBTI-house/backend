package com.house.mbit.core.jwt;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    private static final String ISS = "SYSTEM";
    private static final String SUB = "MBTI-TOKEN";
    private static final long ACCESS_TOKEN_VALID_TIME = 1000 * 60 * 60;
    private static final long REFRESH_TOKEN_VALID_TIME = 1000 * 60 * 60 * 30;
    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer";


    @Value("${jwt.token.key}")
    private String key;

    @PostConstruct
    void init() {
        key = Base64.getEncoder().encodeToString(key.getBytes(StandardCharsets.UTF_8));
    }

    public boolean checkHeader(HttpServletRequest request) {
        return request.getHeader(AUTHORIZATION) == null;
    }

    public String resolve(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION);

        return token.replace(BEARER + " ", "");
    }

    public String createAccessToken(Long userId, String role) {
        return createToken(userId, role, ACCESS_TOKEN_VALID_TIME);
    }

    public String createRefreshToken(Long userId, String role) {
        return createToken(userId, role, REFRESH_TOKEN_VALID_TIME);
    }

    private String createToken(Long userId, String role, Long validTokenTime) {
        return Jwts.builder()
            .setHeaderParam("typ", "JWT")
            .setIssuer(ISS)
            .setSubject(SUB)
            .setAudience(userId.toString())
            .claim("role", role)
            .setExpiration(new Date(System.currentTimeMillis() + validTokenTime))
            .signWith(SignatureAlgorithm.HS256, key)
            .compact();
    }

    public Boolean validate(String token, HttpServletRequest request) {
        try {
            Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .after(new Date(System.currentTimeMillis()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser()
            .setSigningKey(key)
            .parseClaimsJws(token)
            .getBody();

        Collection<? extends GrantedAuthority> authorities =
            Arrays.stream(claims.get("role").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        UserDetails principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }
}