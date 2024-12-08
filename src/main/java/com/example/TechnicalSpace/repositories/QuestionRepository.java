package com.example.TechnicalSpace.repositories;

import com.example.TechnicalSpace.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
