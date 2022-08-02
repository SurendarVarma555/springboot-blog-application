package com.springboot.blog.service;

import com.springboot.blog.playload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(long postId,long commentId);

    CommentDto updateComment(long postId,long commentId,CommentDto commentRequest);

    public void deleteComment(long postId,long commentId);


}

