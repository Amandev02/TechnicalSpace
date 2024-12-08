package com.example.TechnicalSpace.services;

import com.example.TechnicalSpace.models.Question;
import com.example.TechnicalSpace.payload.QuestionDTO;

import java.util.List;

public interface QuestionService {

    QuestionDTO addQuestion(Question question);

    String deleteQuestion(Long Questionid);

    List<QuestionDTO> getAllQuestions();



}
