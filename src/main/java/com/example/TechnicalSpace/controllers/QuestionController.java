package com.example.TechnicalSpace.controllers;


import com.example.TechnicalSpace.models.Question;
import com.example.TechnicalSpace.payload.QuestionDTO;
import com.example.TechnicalSpace.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/api/public/ques")
    public ResponseEntity<List<QuestionDTO>> getQuestions(){
      List<QuestionDTO> questionsList = questionService.getAllQuestions();
      return new ResponseEntity<>(questionsList, HttpStatus.OK);
    }

    @PostMapping("/api/admin/ques")
    public ResponseEntity<QuestionDTO> addQuestion(Question question) {
          QuestionDTO questiondto = questionService.addQuestion(question);
          return new ResponseEntity<>(questiondto,HttpStatus.CREATED);
    }

    @DeleteMapping("/api/admin/ques/{QuestionId}")
    public String deleteQuestion(@PathVariable Long QuestionId){
        String status = questionService.deleteQuestion(QuestionId);
        return status;
    }
}
