package com.example.quizservice.Service;


import com.example.quizservice.Dao.QuizDao;
import com.example.quizservice.Model.QuestionWrapper;
import com.example.quizservice.Model.Quiz;
import com.example.quizservice.Model.Response;
import com.example.quizservice.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
  //  RestTemplate
    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuizInterface quizInterface;

    public ResponseEntity<String> CreateQuiz(String cat, String title, int noQ) {

        List<Integer> questions = quizInterface.getQuestionsByCategory(cat,noQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

//        List<Question> questions = quizDao.findRandomByCategery(cat,noQ);
//        Quiz quiz = new Quiz();
//        quiz.setTitle(title);
//        quiz.setQuestions(questions);
//        quizDao.save(quiz);
        return new ResponseEntity<>("Quiz created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestions(int id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questions = quiz.getQuestions();

        return quizInterface.getQuestions(questions);
    }

    public ResponseEntity<Integer> crt(int id, List<Response> response) {
//        Quiz quiz = quizDao.findById(id).get();
//        List<Question> questions = quiz.getQuestions();
       // int right  = 0;
//        int i = 0;
//        for(Response res : response) {
//            if(res.getAns().equals(questions.get(i).getAnswer())) {
//                right++;
//                i++;
//            }
//        }
        return quizInterface.getScore(response);
    }
}
