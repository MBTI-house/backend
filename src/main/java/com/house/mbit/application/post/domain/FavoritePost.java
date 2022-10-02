package com.house.mbit.application.post.domain;

import com.house.mbit.application.member.domain.Member;
import com.house.mbit.core.jpa.TimeEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class FavoritePost extends TimeEntity {

    @ManyToOne
    private Post post;

    @ManyToOne
    private Member member;
}
