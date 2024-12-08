package com.example.TechnicalSpace.services;


import com.example.TechnicalSpace.models.Comment;
import com.example.TechnicalSpace.models.Post;
import com.example.TechnicalSpace.payload.CommentDTO;
import com.example.TechnicalSpace.payload.PostDTO;

import java.util.List;

public interface PostService {

     List<PostDTO> getAllPosts();

     PostDTO createPost(Long categoryId, Post post);

     String deletePost(Long postId);

     CommentDTO addCommentToPost(Long postId, Comment comment);

     List<CommentDTO> getCommentsFromPost(Long postId);






}
