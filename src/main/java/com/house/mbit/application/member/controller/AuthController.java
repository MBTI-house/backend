package com.house.mbit.application.member.controller;

import com.house.mbit.application.member.dto.MemberDto;
import com.house.mbit.application.member.dto.MemberInfoDto;
import com.house.mbit.application.member.service.MemberFacade;
import com.house.mbit.application.member.service.MemberService;
import com.house.mbit.core.common.ApiResponse;
import com.house.mbit.core.jwt.JwtTokenProvider;
import com.house.mbit.core.util.CookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private static final String ACCESS_TOKEN = "access_token";
    private static final String REFRESH_TOKEN = "refresh_token";

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberFacade memberFacade;

    @PostMapping("/auth/login")
    public ApiResponse login(@RequestBody MemberInfoDto memberInfoDto, HttpServletResponse response) {
        MemberDto memberDto = memberFacade.login(memberInfoDto.toEntity());

        response.addCookie(CookieUtil.generator(
            ACCESS_TOKEN, jwtTokenProvider.createAccessToken(memberDto.getId(), memberDto.getMemberRole().toString())));
        response.addCookie(CookieUtil.generator(
            REFRESH_TOKEN, jwtTokenProvider.createRefreshToken(memberDto.getId(), memberDto.getMemberRole().toString())));

        return ApiResponse.noContent();
    }

    @PostMapping("/auth/logout")
    public ApiResponse logout(HttpServletResponse response) {
        response.addCookie(CookieUtil.expire(ACCESS_TOKEN));
        response.addCookie(CookieUtil.expire(REFRESH_TOKEN));

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
