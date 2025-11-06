package com.example.quizservice.Dao;


import com.example.quizservice.Model.Quiz;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface QuizDao extends JpaRepository<Quiz, Integer> {

    @Query(value = "select * from question q where category = :cat order by RAND() LIMIT :noQ", nativeQuery = true)
    List<TypePatternQuestions.Question> findRandomByCategery(String cat, int noQ);
}
