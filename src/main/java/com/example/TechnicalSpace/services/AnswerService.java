package com.example.TechnicalSpace.services;

import com.example.TechnicalSpace.models.Answer;
import com.example.TechnicalSpace.payload.AnswerDTO;

import java.util.List;


public interface AnswerService {

    AnswerDTO addAnswer(Long QuestionId , Answer answer);

    List<AnswerDTO> getAllAnswers(Long QuestionId);

    String deleteAnswer(Long AnswerId);

}
