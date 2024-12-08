package com.example.TechnicalSpace.models;

//import com.example.TechnicalSpace.payload.CommentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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



    private LocalDateTime createdAt =  LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JsonIgnore
    private User author;


    @Override
    public int hashCode(){
        return Objects.hash(postId);
    }

//    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL)
//    private List<Comment> comments;

}
