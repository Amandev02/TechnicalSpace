package com.example.TechnicalSpace.models;

//import com.example.TechnicalSpace.payload.CommentDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "posts")
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String postName;
    private String postDescription;
    private String image;
    private Long likes;

//    public Post(String postName, String postDescription, String image, Long likes, LocalDate createdAt, Category category, User author) {
//        this.postName = postName;
//        this.postDescription = postDescription;
//        this.image = image;
//        this.likes = likes;
//        this.createdAt = createdAt;
//        this.category = category;
//        this.author = author;
//    }

    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    private User author;

//    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL)
//    private List<Comment> comments;

}
