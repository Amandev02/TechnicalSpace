package com.example.TechnicalSpace.services;

import com.example.TechnicalSpace.models.Post;
import com.example.TechnicalSpace.payload.PostDTO;

import java.util.List;

public interface PostService {

     List<PostDTO> getAllPosts();

     PostDTO createPost(Long categoryId, Post post);



}
