package com.house.mbti.application.post.controller;

import com.house.mbti.application.member.domain.Mbti;
import com.house.mbti.core.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class InformationController {

    @GetMapping("/information")
    public ApiResponse mbtiInfo(Mbti mbti) {
        //TODO mbti 정보 page 전달
        return ApiResponse.success(null);
    }
}
