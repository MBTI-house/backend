package com.house.mbit.application.post.repository;

import com.house.mbit.application.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
