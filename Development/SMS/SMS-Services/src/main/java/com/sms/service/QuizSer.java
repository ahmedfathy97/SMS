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


    public void submitQuizAnswers( int studentID ,int quizID ,List<StudentAnswerDTO> studentAnswerDTOList)
    {
        boolean isCorrect ;
        List<ModelAnswerVTO> modelAnswerVTOList =quizRep.getQuestionsModelAnswer(quizID) ;
        for(StudentAnswerDTO studentAnswer :studentAnswerDTOList)
        {
            isCorrect =this.gradQuestionForStudent( studentAnswer ,modelAnswerVTOList) ;
            quizRep.submitQuestionAnswer(studentID ,quizID ,isCorrect,studentAnswer);
        }

    }


//    public boolean gradQuestionForStudent(StudentAnswerDTO studentAnswerDTO)
//    {
//
//    }
//
    public boolean gradQuestionForStudent( StudentAnswerDTO studentAnswer ,List<ModelAnswerVTO> modelAnswerVTOList )
    {
        boolean isCorrect =false  ;
           for (ModelAnswerVTO modelAnswer : modelAnswerVTOList)
           {
               if (studentAnswer.getQuestionID()==modelAnswer.getQuestionID())
               {
                   if(studentAnswer.getStudentAnswer().equals(modelAnswer.getModelAnswer()))
                   {
                       isCorrect =true ;
                   }
               }
           }

       return isCorrect ;
    }

    }


