package com.example.quizservice.Controller;


import com.example.quizservice.Model.QuestionWrapper;
import com.example.quizservice.Model.QuizDto;
import com.example.quizservice.Model.Response;
import com.example.quizservice.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/Create")
    public ResponseEntity<String> create(@RequestBody QuizDto quizDto) {
       return quizService.CreateQuiz(quizDto.getCatName(),quizDto.getTitle(),quizDto.getNumOfQuestions());

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> get(@PathVariable int id) {

        return quizService.getQuestions(id);
    }

    @PostMapping("/Submit/{id}")
    public ResponseEntity<Integer> submit(@PathVariable int id, @RequestBody List<Response> response) {
        return quizService.crt(id,response);

    }
}
