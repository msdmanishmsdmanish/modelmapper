package com.modelmapper.modelmapper.service;

import com.modelmapper.modelmapper.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);

    List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

    void deletePostById(long id);

    PostDto updatePost(PostDto postDto, long id);
}
