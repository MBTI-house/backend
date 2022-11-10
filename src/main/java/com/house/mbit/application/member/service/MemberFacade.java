package com.house.mbit.application.member.service;

import com.house.mbit.application.member.domain.Member;
import com.house.mbit.application.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberFacade {

    private final MemberService memberService;


    //TODO 최초 로그인시 회원가입, 또는 유저체크(로그인을 위한)
    public MemberDto login(Member toEntity) {
        return null;
    }
}
