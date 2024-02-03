package com.modelmapper.modelmapper.service;

import com.modelmapper.modelmapper.entity.Comment;
import com.modelmapper.modelmapper.entity.Post;
import com.modelmapper.modelmapper.exception.ResourceNotFoundException;
import com.modelmapper.modelmapper.payload.CommentDto;
import com.modelmapper.modelmapper.repository.CommentRepository;
import com.modelmapper.modelmapper.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService{
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post=postRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post is Not Found with Id:"+postId)
       );
         Comment comment=new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);
        Comment savedComment=commentRepository.save(comment);
        CommentDto dto=new CommentDto();
        dto.setId(savedComment.getId());
        dto.setEmail(savedComment.getEmail());
        dto.setText(savedComment.getText());
        return dto;
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto, long postId) {
        Post post=postRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post is Not Found with Id:"+postId)
        );
        Comment comment=commentRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Comment is Not Found with Id:"+postId)
        );

        //Comment comment=new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);
        Comment savedComment=commentRepository.save(comment);
        CommentDto dto=new CommentDto();
        dto.setId(savedComment.getId());
        dto.setEmail(savedComment.getEmail());
        dto.setText(savedComment.getText());
        return dto;

    }

    @Override
    public CommentDto getCommentById(long id) {
        Comment comment=commentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Comment is Not Found with Id:"+id)
        );

        CommentDto dto=new CommentDto();
        dto.setId(comment.getId());
        dto.setEmail(comment.getEmail());
        dto.setText(comment.getText());
        return dto;
    }

    @Override
    public List<CommentDto> getAllComment() {

        List<Comment>comments=commentRepository.findAll();
        List<CommentDto>dtos=comments.stream().map(p->mapToDto(p)).collect(Collectors.toList());
        return dtos;
    }
    CommentDto mapToDto(Comment comment){
        CommentDto dto=new CommentDto();
        dto.setId(comment.getId());
        dto.setEmail(comment.getEmail());
        dto.setText(comment.getText());
        return dto;
    }
    Comment mapToEntity(CommentDto commentDto){
        Comment comment=new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        //comment.setPost(post);
        return comment;
    }
}
