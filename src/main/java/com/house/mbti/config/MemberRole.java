package com.house.mbti.config;

public enum MemberRole {
    MEMBER("M"),
    ADMIN("A");

    private String code;

    MemberRole(String code) {
        this.code = code;
    }
}
