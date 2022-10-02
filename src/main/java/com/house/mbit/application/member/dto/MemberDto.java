package com.house.mbit.application.member.dto;

import com.house.mbit.application.member.domain.Mbti;
import lombok.Data;

@Data
public class MemberDto {

    public String profileName;
    public Mbti mbti;
    public int point;
}
