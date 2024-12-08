package com.example.TechnicalSpace.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "answers")
@ToString
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(nullable = false)
    private String answerContent;


    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    @JsonIgnore
    private Question question;

    @ToString.Exclude
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    private Long upvotes = 0L;
    private Long downvotes = 0L;

    @Column(nullable = false, updatable = false)
    private java.time.LocalDateTime createdDate = java.time.LocalDateTime.now();

    private java.time.LocalDateTime lastUpdatedDate = java.time.LocalDateTime.now();

}
