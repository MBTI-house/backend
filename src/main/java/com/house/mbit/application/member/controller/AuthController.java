package com.house.mbit.application.member.controller;

import com.house.mbit.core.common.ApiResponse;
import com.house.mbit.core.jwt.JwtTokenProvider;
import com.house.mbit.core.util.CookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private static final String ACCESS_TOKEN = "access_token";
    private static final String REFRESH_TOKEN = "refresh_token";

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/auth/login")
    public ApiResponse login(String code, HttpServletResponse response) {
        //https://velog.io/@bgg01578/%EC%B9%B4%EC%B9%B4%EC%98%A4-%EB%A1%9C%EA%B7%B8%EC%9D%B8
        //https://mangchhe.github.io/springboot/2021/07/18/SpringKakaoLogin/
        //TODO 카카오 인가코드 처리
        //TODO 최초 로그인시 회원가입, 또는 유저체크(로그인을 위한)
        response.addCookie(CookieUtil.generator(ACCESS_TOKEN, null));
        response.addCookie(CookieUtil.generator(REFRESH_TOKEN, null));
        //TODO - refrershToken 저장

        return ApiResponse.noContent();
    }

    @PostMapping("/auth/logout")
    public ApiResponse logout(HttpServletResponse response) {
        response.addCookie(CookieUtil.expire(ACCESS_TOKEN));
        response.addCookie(CookieUtil.expire(REFRESH_TOKEN));

        //TODO - refreshToken 삭제

        return ApiResponse.noContent();
    }

    @PostMapping("/auth/refresh/token")
    public ApiResponse accessTokenGenerator(HttpServletRequest request, HttpServletResponse response) {
        //TODO - refrershToken 체크
        //TODO - accessToken 발급
        response.addCookie(CookieUtil.generator(ACCESS_TOKEN, null));

        return ApiResponse.noContent();
    }
}
