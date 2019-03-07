package com.sms.service;

import com.sms.model.course.QuizDTO;
import com.sms.repository.CourseRep;
import com.sms.repository.QuizRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSer {
    private CourseRep courseRep ;
    private QuizRep quizRep ;
    @Autowired
    public CourseSer(CourseRep courseRep , QuizRep quizRep) {
        this.courseRep = courseRep;
        this.quizRep = quizRep ;
    }




    public void createQuiz(int courseID ,QuizDTO quizData )
    {

        courseRep.insertNewQuiz(courseID,quizData);
    }

    public void createQuizClosure (int courseID,int quizID , QuizDTO data)
    {
            quizRep.getCloseDate(courseID,quizID);
            quizRep.createQuizClosure(courseID,quizID ,data);

    }

}
