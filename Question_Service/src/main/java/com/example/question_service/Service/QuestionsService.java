package com.example.question_service.Service;


import com.example.question_service.Dao.QuestionDao;
import com.example.question_service.Model.Question;
import com.example.question_service.Model.QuestionWrapper;
import com.example.question_service.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    @Autowired
    QuestionDao questionsDao;

    public ResponseEntity<List<Question>> getAll() {
        try {
            return new ResponseEntity<>(questionsDao.findAll(), HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Question>> getByCategory(String cat) {
        try {
            return new ResponseEntity<>(questionsDao.findByCategory(cat),HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Question> add(Question question) {
        return new ResponseEntity<>(questionsDao.save(question),HttpStatus.ACCEPTED);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String cat, int limit) {

        List<Integer> questions = questionsDao.findRandomByCategery(cat,limit);

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> ids) {
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        List<Question> questions = questionsDao.findAll();
        for (Integer id : ids) {
            Optional<Question> optionalQuestion = questionsDao.findById(id);
            if (optionalQuestion.isPresent()) {
                Question question = optionalQuestion.get();
                QuestionWrapper questionWrapper = new QuestionWrapper();
                questionWrapper.setId(question.getId());
                questionWrapper.setQuestion(question.getQuestion());
                questionWrapper.setOption1(question.getOption1());
                questionWrapper.setOption2(question.getOption2());
                questionWrapper.setOption3(question.getOption3());
                questionWrapper.setOption4(question.getOption4());

                questionWrappers.add(questionWrapper);
            }
        }
        return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int score = 0;
        for (Response response : responses) {
            Question question = questionsDao.findById(response.getId()).get();
            if(response.getAns().equals(question.getAnswer())) {
                score++;
            }
        }
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
