package com.example.TechnicalSpace.services;

import com.example.TechnicalSpace.exceptions.ResourceNotFoundException;
import com.example.TechnicalSpace.models.Category;
//import com.example.TechnicalSpace.models.Comment;
import com.example.TechnicalSpace.models.Comment;
import com.example.TechnicalSpace.models.Post;
import com.example.TechnicalSpace.models.User;
import com.example.TechnicalSpace.payload.CommentDTO;
import com.example.TechnicalSpace.payload.PostDTO;
import com.example.TechnicalSpace.repositories.CategoryRepository;
import com.example.TechnicalSpace.repositories.CommentRepositories;
import com.example.TechnicalSpace.repositories.PostRepository;
import com.example.TechnicalSpace.util.AuthUtil;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthUtil authUtil;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CommentRepositories commentRepositories;


    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> modelMapper.map(post, PostDTO.class))
                .toList();
    }

    @Override
    public PostDTO createPost(Long categoryId, Post post) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("category","categoryName",categoryId));
        post.setImage(post.getImage());
        User user = authUtil.loggedInUser();
        post.setAuthor(user);
        post.setCategory(category);


        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDTO.class);
    }

    @Transactional
    @Override
    public String deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post","postId",postId));
        postRepository.delete(post);
        return "Post " + post.getPostName() + " deleted successfully";
    }


        @Override
    public CommentDTO addCommentToPost(Long postId, Comment comment) {
          Post post = postRepository.findById(postId)
                          .orElseThrow(()-> new ResourceNotFoundException("post","PostId",postId));
        comment.setPosts(post);

        Comment savedComment = commentRepositories.save(comment);
        return modelMapper.map(savedComment, CommentDTO.class);
    }

    @Override
    public List<CommentDTO> getCommentsFromPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post","PostId",postId));
        List<Comment> comments = commentRepositories.findByPostId(postId);
         return comments.stream()
                .map(comment -> modelMapper.map(comment, CommentDTO.class))
                .toList();
    }


}























