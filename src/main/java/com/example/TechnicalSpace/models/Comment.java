package com.example.TechnicalSpace.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String comment;

    private LocalDateTime createdAt =  LocalDateTime.now();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Posts")
    private Post posts;


    @ManyToOne
    @JsonIgnore
    private User author;
}
