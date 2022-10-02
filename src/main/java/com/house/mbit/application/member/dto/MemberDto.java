package com.house.mbit.application.member.dto;

import com.house.mbit.application.member.domain.Mbti;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String profileName;
    private Mbti mbti;
    private int point;
}
