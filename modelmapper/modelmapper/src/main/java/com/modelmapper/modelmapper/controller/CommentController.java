package com.modelmapper.modelmapper.controller;

import com.modelmapper.modelmapper.payload.CommentDto;
import com.modelmapper.modelmapper.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping  //http://localhost:8080/api/comment?postId=1
    public ResponseEntity<CommentDto>createComment(@RequestBody CommentDto commentDto,
                                                    @RequestParam long postId){

       CommentDto dto= commentService.createComment(commentDto,postId);
       return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")   //http://localhost:8080/api/comment/2
    public ResponseEntity<String>deleteComment(@PathVariable long id){
        commentService.deleteComment(id);
        return new ResponseEntity<>("Comment is deleted",HttpStatus.OK);
    }
    @PutMapping("/{id}/post/{postId}") //http://localhost:8080/api/comment/1/post/1
    public ResponseEntity<CommentDto>updateComment(@PathVariable long id,@RequestBody CommentDto commentDto,@PathVariable long postId){
        CommentDto dto=commentService.updateComment(id,commentDto,postId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/a")  //http://localhost:8080/api/comment/a?id=1
    public ResponseEntity<CommentDto>getCommentById(@RequestParam long id){
        CommentDto dto=commentService.getCommentById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping  //http://localhost:8080/api/comment?id
    public List<CommentDto> getAllComment(){
        List<CommentDto>dtos=commentService.getAllComment();
        return dtos;
    }
}
