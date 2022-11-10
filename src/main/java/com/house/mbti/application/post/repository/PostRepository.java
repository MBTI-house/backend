package com.house.mbti.application.post.repository;

import com.house.mbti.application.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
