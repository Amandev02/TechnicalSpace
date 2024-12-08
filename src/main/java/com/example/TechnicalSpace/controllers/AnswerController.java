package com.example.TechnicalSpace.controllers;


import com.example.TechnicalSpace.models.Answer;
import com.example.TechnicalSpace.payload.AnswerDTO;
import com.example.TechnicalSpace.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    AnswerService answerService;


     @GetMapping("/api/ans/{QuestionId}")
    public ResponseEntity<List<AnswerDTO>> getAllAnswers(@PathVariable Long QuestionId){
        List<AnswerDTO> answers = answerService.getAllAnswers(QuestionId);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @PostMapping("/api/ans/{QuestionId}")
    public ResponseEntity<AnswerDTO> addAnswer(@PathVariable Long QuestionId, @RequestBody Answer answer){
        AnswerDTO ans = answerService.addAnswer(QuestionId,answer);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/ans/{AnswerId}")
    public String deleteAnswer(@PathVariable Long AnswerId){
        String status = answerService.deleteAnswer(AnswerId);
        return status;
    }
}
