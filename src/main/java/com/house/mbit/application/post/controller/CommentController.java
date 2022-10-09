package com.house.mbit.application.post.controller;

import com.house.mbit.application.member.dto.MemberDto;
import com.house.mbit.application.post.dto.CommentDto;
import com.house.mbit.application.post.dto.PostDto;
import com.house.mbit.core.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class CommentController {

    @PostMapping("/comment")
    public ApiResponse newComment(@RequestBody CommentDto commentDto, Principal principal) {
        //TODO 댓글 생성
        return ApiResponse.success(new CommentDto());
    }

    @PutMapping("/comment")
    public ApiResponse modifyComment(@RequestBody CommentDto commentDto, Principal principal) {
        //TODO 댓글 수정
        return ApiResponse.success(new CommentDto());
    }

    @DeleteMapping("/comment")
    public ApiResponse deleteComment(Long commentId, Principal principal) {
        //TODO 댓글 삭제
        return ApiResponse.success(new CommentDto());
    }

    @GetMapping("/comment")
    public ApiResponse getComment(Long commentId, Principal principal) {
        //TODO 댓글 조회
        return ApiResponse.success(new CommentDto());
    }

    @GetMapping("/comments")
    public ApiResponse getComments(Pageable pageable, Principal principal) {
        //TODO 댓글 리스트
        return ApiResponse.success(new CommentDto());
    }

}
