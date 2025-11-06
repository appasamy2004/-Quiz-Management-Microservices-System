package com.example.question_service.Controller;


import com.example.question_service.Model.Question;
import com.example.question_service.Model.QuestionWrapper;
import com.example.question_service.Model.Response;
import com.example.question_service.Service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Questions")
public class QuestionController {

    @Autowired
    private QuestionsService questionsService;

    @GetMapping("/AllQuestions")
    public ResponseEntity<List<Question>> getQuestions() {
        return questionsService.getAll();
    }
    @GetMapping("/Question/{cat}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String cat) {
        return questionsService.getByCategory(cat);

    }
    public ResponseEntity<Question> addQuestion(@RequestParam Question question) {
        return questionsService.add(question);
    }

    //generate
    //getquestions(questionid)
    //get score

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsByCategory(@RequestParam String cat, @RequestParam int limit) {
        return questionsService.getQuestionsForQuiz(cat,limit);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> id) {
        return questionsService.getQuestionsFromId(id);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
        return questionsService.getScore(responses);
    }
}
