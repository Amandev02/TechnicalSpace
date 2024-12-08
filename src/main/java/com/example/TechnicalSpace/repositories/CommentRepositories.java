package com.example.TechnicalSpace.repositories;

import com.example.TechnicalSpace.models.Comment;
import com.example.TechnicalSpace.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepositories extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.posts.postId = ?1")
    List<Comment> findByPostId(Long postId);



}
