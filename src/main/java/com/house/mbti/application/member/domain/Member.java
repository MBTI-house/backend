package com.house.mbti.application.member.domain;

import com.house.mbti.config.MemberRole;
import com.house.mbti.core.jpa.TimeEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends TimeEntity {

    private String email;
    private String profileName;
    private String refreshToken;
    private int point;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Enumerated(EnumType.STRING)
    private Mbti mbti;

}
