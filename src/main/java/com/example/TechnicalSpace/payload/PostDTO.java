package com.example.TechnicalSpace.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

  //  private Long postId;
    private String postName;
    private String postDescription;
    private String image;
    private Long likes;
    private LocalDateTime createdAt;


}
