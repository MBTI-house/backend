package com.house.mbit.application.member.dto;

import com.house.mbit.application.member.domain.Member;
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
