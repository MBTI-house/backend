package com.house.mbit.application.member.controller;

import com.house.mbit.core.common.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health/check")
    public ApiResponse healthCheck() {
        return ApiResponse.success("health check");
    }
}
