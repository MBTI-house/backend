package com.house.mbti.core.exception;

public enum ExceptionMessage {
    TOKEN_FALUT ("잘못된 형식의 Token 입니다"),
    SC_FORBIDDEN ("접근 권한이 없습니다");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}