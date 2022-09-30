package com.house.mbit.core.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApiResponse {
    private int code;
    private String message;
    private Object data;

    public ApiResponse(Object data) {
        this(1000, "success", data);
    }
    public ApiResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ApiResponse noContent() {
        return new ApiResponse("");
    }

    public static ApiResponse success(Object data) {
        return new ApiResponse(data);
    }

    public static ApiResponse fail(int code, String message, Object data) {
        return new ApiResponse(code, message, data);
    }

}
