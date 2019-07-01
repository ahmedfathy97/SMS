package com.sms.service;

import com.sms.model.course.ExamInformationVTO;
import com.sms.model.course.quiz.*;
import com.sms.model.user.UserVTO;
import com.sms.repository.ExamRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamSer {
    private ExamRep examRep ;

    @Autowired
    public ExamSer(ExamRep examRep) {
        this.examRep = examRep;
    }

    public void createExamQuestions(int examID , List<QuestionDTO> questionList)
    {
        for(QuestionDTO questionData :questionList)
        {
            examRep.insertNewQuestion(examID ,questionData);
        }
    }

    public List<QuestionVTO> getExamQuestions(int examID)
    {
        List<QuestionVTO> questionList = examRep.getExamQuestions(examID) ;
        return questionList ;
    }







    public void submitExamAnswers(int studentID , int examID , List<StudentAnswerDTO> studentAnswerDTOList)
    {
        QuestionEvaluate evaluateStudentAnswer ;
        List<ModelAnswerVTO> modelAnswerVTOList =examRep.getQuestionsModelAnswer(examID) ;
        int totalScore = 0;
        for(StudentAnswerDTO studentAnswer :studentAnswerDTOList)
        {
            evaluateStudentAnswer =this.gradQuestionForStudent( studentAnswer ,modelAnswerVTOList) ;
            totalScore += evaluateStudentAnswer.getStudentGrade();
            examRep.submitQuestionAnswer(studentID ,examID,evaluateStudentAnswer,studentAnswer);
        }

        String examType = examRep.getExamType(examID) ;
        if(examType.equals("Mid Term"))
        {
             examRep.UpdateMidGrade(studentID ,totalScore);
        }else if(examType.equals("Final Exam"))
        {
            examRep.updateFinalGrade(studentID ,totalScore);
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


    public void closeExam(int examID)
    {

        examRep.closeExam(examID);
    }


    public ExamInformationVTO getExamInformation(int examID)
    {
        return examRep.getExamInformation(examID) ;
    }


    public List<QuizResult> getExamResult(int studentID , int examID  )
    {
        return examRep.getExamResult(studentID ,examID ) ;
    }

    public int examState(UserVTO currentUser , int examID)
    {

        int examState ;
        if(currentUser.getRoleIDs().contains(1))
        {
            boolean examputted =examRep.examPutted(examID) ;
            if (examputted == true)
            {
                examState = 1 ;
            }
            else{
                examState =5 ;
            }

        }
        else
        {
            boolean isOpened = examRep.isExamOpen(examID) ;
            if(isOpened==true) {
                boolean isAnswered = examRep.isAnswered(currentUser.getId(), examID);
                if (isAnswered == true)
                {
                    examState = 3 ;
                }
                else
                {
                    examState = 4 ;
                }
            } else
            {
                examState =2 ;
            }

        }
        return examState ;
    }


}
