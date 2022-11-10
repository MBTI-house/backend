package com.house.mbti.application.post.controller;

import com.house.mbti.application.member.domain.Mbti;
import com.house.mbti.application.member.dto.MemberDto;
import com.house.mbti.application.post.dto.PostDto;
import com.house.mbti.core.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class PostController {

    @PostMapping("/post")
    public ApiResponse newPost(@RequestBody PostDto postDto, Principal principal) {
        //TODO 게시판 생성
        return ApiResponse.success(new PostDto());
    }

    @PostMapping("/favorite/post")
    public ApiResponse favoritePost(Long postId, Principal principal) {
        //TODO 게시판 좋아요
        return ApiResponse.success(new PostDto());
    }

    @PutMapping("/post")
    public ApiResponse modifyPost(@RequestBody PostDto postDto, Principal principal) {
        //TODO 게시판 수정
        return ApiResponse.success(new PostDto());
    }

    @DeleteMapping("/post")
    public ApiResponse deletePost(Long postId, Principal principal) {
        //TODO 게시판 삭제
        return ApiResponse.success(new PostDto());
    }

    @GetMapping("/post")
    public ApiResponse getPost(Long postId, Mbti mbti, Principal principal) {
        //TODO 게시판 조회
        return ApiResponse.success(new PostDto());
    }

    @GetMapping("/posts")
    public ApiResponse getPosts(Pageable pageable, Mbti mbti, Principal principal) {
        //TODO 게시판 리스트 반환
        return ApiResponse.success(new MemberDto());
    }


}
