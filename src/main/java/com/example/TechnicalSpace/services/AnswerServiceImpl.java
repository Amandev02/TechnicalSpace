package com.example.TechnicalSpace.services;

import com.example.TechnicalSpace.exceptions.ResourceNotFoundException;
import com.example.TechnicalSpace.models.Answer;
import com.example.TechnicalSpace.models.Question;
import com.example.TechnicalSpace.models.User;
import com.example.TechnicalSpace.payload.AnswerDTO;
import com.example.TechnicalSpace.payload.PostDTO;
import com.example.TechnicalSpace.repositories.AnswerRepository;
import com.example.TechnicalSpace.repositories.QuestionRepository;
import com.example.TechnicalSpace.util.AuthUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {


    @Autowired
    private AuthUtil authUtil;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AnswerDTO addAnswer(Long QuestionId , Answer answer) {
      User user = authUtil.loggedInUser();
      Question question = questionRepository.findById(QuestionId)
              .orElseThrow(() -> new ResourceNotFoundException("Question","QuestionId",QuestionId));
      answer.setQuestion(question);
      answer.setAuthor(user);
        Answer savedAnswer = answerRepository.save(answer);
        return modelMapper.map(savedAnswer, AnswerDTO.class);
    }

    @Override
    public List<AnswerDTO> getAllAnswers(Long QuestionId) {
        Question question = questionRepository.findById(QuestionId)
                .orElseThrow(() -> new ResourceNotFoundException("Question", "QuestionId", QuestionId));
        List<Answer> answers = question.getAnswers();
        return answers.stream()
                .map(ans -> modelMapper.map(ans, AnswerDTO.class))
                .toList();

    }

    @Override
    public String deleteAnswer(Long AnswerId) {
        Answer answer = answerRepository.findById(AnswerId)
                .orElseThrow(() -> new ResourceNotFoundException("Question", "QuestionId", AnswerId));
        return "Answer Deleted Successfully";
    }
}
