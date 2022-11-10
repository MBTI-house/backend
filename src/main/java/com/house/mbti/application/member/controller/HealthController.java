package com.house.mbti.application.member.controller;

import com.house.mbti.core.common.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health/check")
    public ApiResponse healthCheck() {
        return ApiResponse.success("health check");
    }
}
