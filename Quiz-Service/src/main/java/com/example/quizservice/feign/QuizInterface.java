package com.example.quizservice.feign;

import com.example.quizservice.Model.QuestionWrapper;
import com.example.quizservice.Model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("/Questions/generate")
    public ResponseEntity<List<Integer>> getQuestionsByCategory(@RequestParam("cat") String cat,
                                                                @RequestParam("limit") int limit);

    @PostMapping("/Questions/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> id);

    @PostMapping("/Questions/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
