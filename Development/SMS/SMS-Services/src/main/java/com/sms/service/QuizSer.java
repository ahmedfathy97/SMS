package com.sms.service;
import com.sms.model.course.QuizDTO;
import com.sms.repository.QuizRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizSer {
    private QuizRep quizRep ;
    @Autowired
    public QuizSer(QuizRep quizRep) {
        this.quizRep =quizRep ;
    }

      public void createQuiz(QuizDTO quizData )
     {

         quizRep.insertNewQuiz(quizData);
     }
}
