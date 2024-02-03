package com.modelmapper.modelmapper.controller;

import com.modelmapper.modelmapper.payload.PostDto;
import com.modelmapper.modelmapper.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manish")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping //http://localhost:8080/manish
    public ResponseEntity<PostDto>createPost(@RequestBody PostDto postDto){
        PostDto dto=postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/a")  //http://localhost:8080/manish/a?id=2
    public ResponseEntity<PostDto>getPostById(@RequestParam long id){
        PostDto dto=postService.getPostById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }
    @GetMapping  //http://localhost:8080/manish?pageNo=0&pageSize=3&sortBy=title&sortDir=desc
    public List<PostDto> getAllPost(
            @RequestParam(name="pageNo",required = false,defaultValue = "0")int pageNo,
            @RequestParam(name="pageSize",required = false,defaultValue = "3")int pageSize,
            @RequestParam(name="sortBy",required = false,defaultValue = "id")String sortBy,
            @RequestParam(name="sortDir",required = false,defaultValue = "id")String sortDir

    ){
       List<PostDto>dto=postService.getAllPost(pageNo,pageSize,sortBy,sortDir);
       return dto;


    }
    @DeleteMapping("/{id}")  //http://localhost:8080/manish/7
    public ResponseEntity<String>deletePostById(@PathVariable long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post is deleted",HttpStatus.OK);
    }
    @PutMapping()  //http://localhost:8080/manish?id=2
    public ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto,@RequestParam long id){
        PostDto dto=postService.updatePost(postDto,id);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
