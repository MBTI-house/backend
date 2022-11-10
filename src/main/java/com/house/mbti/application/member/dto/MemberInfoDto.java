package com.house.mbti.application.member.dto;

import com.house.mbti.application.member.domain.Member;
import lombok.Data;

@Data
public class MemberInfoDto {
    public String email;
    public String memberId;
    public String nickname;

    public Member toEntity() {
        return null;
    }
}
