package com.sms.service;
import com.sms.model.course.QuestionDTO;
import com.sms.model.course.QuizDTO;
import com.sms.model.course.QuestionVTO;
import com.sms.repository.QuizRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.PathParam;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
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

    public List<QuestionVTO> getQuizQuestions(int quizID)
    {
        List<QuestionVTO> questionList = quizRep.getQuizQuestions(quizID) ;
        return questionList ;
    }


    public Date getCloseDate( int quizID) {
        Date closeDate =this.quizRep.getCloseDate(quizID);
        return closeDate;
    }


    public void createQuizClosure (int quizID)
    {
        Date finishDate =  this.getCloseDate(quizID);

        Instant closeDate = finishDate.toInstant();
        Instant currentDate = ZonedDateTime.now().toInstant();

        if(currentDate.isAfter(closeDate))
        {
            quizRep.createQuizClosure(quizID);
        }


    }
    }


