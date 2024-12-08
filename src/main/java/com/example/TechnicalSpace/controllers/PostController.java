package com.example.TechnicalSpace.controllers;


import com.example.TechnicalSpace.models.Comment;
import com.example.TechnicalSpace.models.Post;
import com.example.TechnicalSpace.payload.CommentDTO;
import com.example.TechnicalSpace.payload.PostDTO;
import com.example.TechnicalSpace.services.PostService;
import jakarta.validation.Valid;
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
    public ResponseEntity<PostDTO> createPost(@Valid @PathVariable Long categoryId, @RequestBody Post post){
        PostDTO postDTO = postService.createPost(categoryId, post);
        return new ResponseEntity<>(postDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/posts/{postId}")
    public ResponseEntity<String> deletePost(@Valid @PathVariable Long postId){
        String status = postService.deletePost(postId);

        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

        @GetMapping("/public/posts/comments/{postId}")
    public ResponseEntity<List<CommentDTO>> getComments(@PathVariable Long postId){
       List<CommentDTO> comments = postService.getCommentsFromPost(postId);
       return new ResponseEntity<>(comments,HttpStatus.OK);
    }


    @PostMapping("/admin/posts/{postId}")
    public ResponseEntity<CommentDTO> addComment(@Valid @PathVariable Long postId, @RequestBody Comment comment){
        CommentDTO comments =postService.addCommentToPost(postId, comment);
        return new ResponseEntity<>(comments,HttpStatus.CREATED);
    }


}
