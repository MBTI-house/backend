package com.house.mbit.application.member.dto;

import com.house.mbit.application.member.domain.Mbti;
import com.house.mbit.config.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String nickName;
    private MemberRole memberRole;
    private Mbti mbti;
    private int point;
}
