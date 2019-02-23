package com.sms.service;
import com.sms.model.course.QuestionDTO;
import com.sms.repository.QuizRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizSer {
    private QuizRep quizRep ;
    @Autowired
    public QuizSer(QuizRep quizRep) {
        this.quizRep =quizRep ;
    }

    public void createQuizQuestions(int quizID , List<QuestionDTO> questionList)
    {
        for(QuestionDTO questionData :questionList)
        {
            quizRep.insertNewQuestion(quizID ,questionData);
        }


    }
}
