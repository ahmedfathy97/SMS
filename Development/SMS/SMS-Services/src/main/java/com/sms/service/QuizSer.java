package com.sms.service;
import com.sms.controller.filter.AuthenticationFilter;
import com.sms.model.course.quiz.*;
import com.sms.model.user.UserVTO;
import com.sms.repository.QuizRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.PathParam;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
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


    public void submitQuizAnswers( int studentID ,int quizID ,List<StudentAnswerDTO> studentAnswerDTOList)
    {
        QuestionEvaluate evaluateStudentAnswer ;
        List<ModelAnswerVTO> modelAnswerVTOList =quizRep.getQuestionsModelAnswer(quizID) ;
        for(StudentAnswerDTO studentAnswer :studentAnswerDTOList)
        {
            evaluateStudentAnswer =this.gradQuestionForStudent( studentAnswer ,modelAnswerVTOList) ;
            quizRep.submitQuestionAnswer(studentID ,quizID,evaluateStudentAnswer,studentAnswer);
        }

    }



    public QuestionEvaluate gradQuestionForStudent(StudentAnswerDTO studentAnswer , List<ModelAnswerVTO> modelAnswerVTOList )
    {
        QuestionEvaluate questionEvaluate =new QuestionEvaluate();
           for (ModelAnswerVTO modelAnswer : modelAnswerVTOList)
           {
               if (studentAnswer.getQuestionID()==modelAnswer.getQuestionID())
               {
                   if(studentAnswer.getStudentAnswer().equals(modelAnswer.getModelAnswer()))
                   {
                       questionEvaluate.setCorrect(true);
                       questionEvaluate.setStudentGrade(modelAnswer.getQuestionGrade());
                   }
                   else {
                       questionEvaluate.setCorrect(false);
                       questionEvaluate.setStudentGrade(0);
                   }
               }
           }

       return questionEvaluate ;
    }


    public void closeQuiz (int quizID)
    {

        quizRep.closeQuiz(quizID);
    }


    public QuizInformationVTO getQuizInformation(int quizID)
    {
       return quizRep.getQuizInformation(quizID) ;
    }




    }


