package com.example.question_service.Dao;


import com.example.question_service.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, Integer> {
    public List<Question> getByCategory(String cat);

    List<Question> findByCategory( String category);

    @Query(value = "select q.id from question q where category = :cat order by RAND() LIMIT :noQ", nativeQuery = true)
    List<Integer> findRandomByCategery(String cat, int noQ);
}
