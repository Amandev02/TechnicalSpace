package com.example.TechnicalSpace.controllers;


import com.example.TechnicalSpace.models.Post;
import com.example.TechnicalSpace.payload.PostDTO;
import com.example.TechnicalSpace.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/public/posts")
    public ResponseEntity<List<PostDTO>> getAllPosts(){
        List<PostDTO> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @PostMapping("/admin/posts/{categoryId}")
    public ResponseEntity<PostDTO> createPost(@PathVariable Long categoryId, @RequestBody Post post){
        PostDTO postDTO = postService.createPost(categoryId, post);
        return new ResponseEntity<>(postDTO, HttpStatus.CREATED);
    }


}
