package com.house.mbti.application.member.repository;

import com.house.mbti.application.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
