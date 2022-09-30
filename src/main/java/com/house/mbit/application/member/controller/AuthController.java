package com.house.mbit.application.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    @PostMapping("/member/login")
    public void login() {

    }

    @PostMapping("/member/logout")
    public void logout() {

    }

    @PostMapping("/member/token-refresh")
    public void refreshToken() {

    }
}
