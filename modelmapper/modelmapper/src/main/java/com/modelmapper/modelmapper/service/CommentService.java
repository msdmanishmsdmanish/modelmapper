package com.modelmapper.modelmapper.service;

import com.modelmapper.modelmapper.payload.CommentDto;

import java.util.List;

public interface CommentService {


    CommentDto createComment(CommentDto commentDto, long postId);

    void deleteComment(long id);

    CommentDto updateComment(long id, CommentDto commentDto, long postId);

    CommentDto getCommentById(long id);

    List<CommentDto> getAllComment();
}
