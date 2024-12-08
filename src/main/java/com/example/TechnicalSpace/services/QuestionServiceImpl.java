package com.example.TechnicalSpace.services;

import com.example.TechnicalSpace.exceptions.ResourceNotFoundException;
import com.example.TechnicalSpace.models.Question;
import com.example.TechnicalSpace.models.User;
import com.example.TechnicalSpace.payload.PostDTO;
import com.example.TechnicalSpace.payload.QuestionDTO;
import com.example.TechnicalSpace.repositories.QuestionRepository;
import com.example.TechnicalSpace.util.AuthUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AuthUtil authUtil;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionDTO addQuestion(Question question) {
        User user = authUtil.loggedInUser();
        question.setAuthor(user);
        Question savedQuestion = questionRepository.save(question);
        return modelMapper.map(savedQuestion, QuestionDTO.class);

    }

    @Override
    public String deleteQuestion(Long Questionid) {
        Question question = questionRepository.findById(Questionid)
                .orElseThrow(()-> new ResourceNotFoundException("Question","QuestionId",Questionid));
         questionRepository.delete(question);
        return "Question Deleted Successfully";
    }

    @Override
    public List<QuestionDTO> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
                .map(question -> modelMapper.map(question, QuestionDTO.class))
                .toList();
    }
}
