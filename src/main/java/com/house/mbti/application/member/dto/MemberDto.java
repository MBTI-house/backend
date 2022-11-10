package com.house.mbti.application.member.dto;

import com.house.mbti.application.member.domain.Mbti;
import com.house.mbti.config.MemberRole;
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
