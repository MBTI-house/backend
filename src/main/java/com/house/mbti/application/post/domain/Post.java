package com.house.mbti.application.post.domain;

import com.house.mbti.application.member.domain.Mbti;
import com.house.mbti.application.member.domain.Member;
import com.house.mbti.core.jpa.TimeEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends TimeEntity {

    private String title;

    @Enumerated(EnumType.STRING)
    private Mbti mbti;

    @Lob
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    List<FavoritePost> favoritePosts = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Comment> comments = new ArrayList<>();
}
