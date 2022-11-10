package com.house.mbit.core.jwt;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    private static final String ISS = "MBTI-SERVER";
    private static final String BEARER = "Bearer";
    private static final long ACCESS_TOKEN_VALID_TIME = 1000L * 60 * 60;            //1시간
    private static final long REFRESH_TOKEN_VALID_TIME = 1000L * 60 * 60 * 24 * 30; //30일

    @Value("${jwt.token.key}")
    private String key;

    public String parseBearer(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        return token.replace(BEARER + " ", "");
    }

    public String createAccessToken(Long memberId, String role) {
        return createToken(memberId, role, ACCESS_TOKEN_VALID_TIME);
    }

    public String createRefreshToken(Long memberId, String role) {
        return createToken(memberId, role, REFRESH_TOKEN_VALID_TIME);
    }

    private String createToken(Long memberId, String role, Long validTokenTime) {
        return Jwts.builder()
            .setHeaderParam("typ", "JWT")
            .setSubject(memberId.toString())
            .setIssuer(ISS)
            .claim("role", role)
            .setExpiration(new Date(System.currentTimeMillis() + validTokenTime))
            .signWith(SignatureAlgorithm.HS512, key)
            .compact();
    }

    public Boolean validate(String token) {
        try {
            return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .after(new Date(System.currentTimeMillis()));
        } catch (Exception e) {
            throw new RuntimeException(); //TODO exception 별 처리
        }
    }

    public Authentication getAuthentication(String token) {
        Claims body = Jwts.parser()
            .setSigningKey(key)
            .parseClaimsJws(token)
            .getBody();

        Collection<? extends GrantedAuthority> authorities =
            Arrays.stream(body.get("role").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(body.getSubject(), null, authorities);
    }
}