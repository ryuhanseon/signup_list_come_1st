package com.example.demo.Question;

import com.example.demo.Question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer > {
}
