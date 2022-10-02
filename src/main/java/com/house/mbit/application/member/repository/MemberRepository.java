package com.house.mbit.application.member.repository;

import com.house.mbit.application.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
