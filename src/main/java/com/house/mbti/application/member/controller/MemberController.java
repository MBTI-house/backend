package com.house.mbti.application.member.controller;

import com.house.mbti.application.member.dto.MemberDto;
import com.house.mbti.core.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class MemberController {

    @GetMapping("/member/profile")
    public ApiResponse getProfile(Principal principal) {
        //TODO 유저정보 가져오기

        return ApiResponse.success(new MemberDto());
    }

    @PutMapping("/member/profile")
    public ApiResponse modifyProfile(@RequestBody MemberDto memberDto, Principal principal) {
        //TODO 유저정보 수정

        return ApiResponse.success(new MemberDto());
    }
}
