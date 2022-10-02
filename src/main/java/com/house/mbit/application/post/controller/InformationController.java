package com.house.mbit.application.post.controller;

import com.house.mbit.application.member.domain.Mbti;
import com.house.mbit.core.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class InformationController {

    @GetMapping("/information")
    public ApiResponse mbtiInfo(String mbti) {
        //TODO mbti 정보 page 전달
        return ApiResponse.success(null);
    }
}
