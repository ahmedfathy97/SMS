package com.sms.service;
import com.sms.model.course.quiz.ModelAnswerVTO;
import com.sms.model.course.quiz.QuestionDTO;
import com.sms.model.course.quiz.QuestionVTO;
import com.sms.model.course.quiz.StudentAnswerDTO;
import com.sms.repository.QuizRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
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

    //yara start
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
    //yara end


    public void submitQuizAnswers(int quizID ,List<StudentAnswerDTO> studentAnswerDTOList)
    {

    }
    public double gradQuizForStudent( int quizID , List<StudentAnswerDTO> studentAnswerDTOList )
    {
        double studentGrade =0  ;
        List<ModelAnswerVTO> modelAnswerVTOList =quizRep.getQuestionsModelAnswer(quizID) ;
       for(StudentAnswerDTO studentAnswer : studentAnswerDTOList)
       {
           for (ModelAnswerVTO modelAnswer : modelAnswerVTOList)
           {
               if (studentAnswer.getQuestionID()==modelAnswer.getQuestionID())
               {
                   if(studentAnswer.getStudentAnswer().equals(modelAnswer.getModelAnswer()))
                   {
                       studentGrade++ ;
                   }
               }
           }
       }
       return studentGrade ;
    }

    }


