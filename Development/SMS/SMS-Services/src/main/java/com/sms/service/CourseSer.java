package com.sms.service;

import com.sms.model.course.QuizDTO;
import com.sms.repository.CourseRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseSer {
    private CourseRep courseRep ;
    @Autowired
    public CourseSer(CourseRep courseRep) {
        this.courseRep = courseRep;
    }




    public void createQuiz(int courseID ,QuizDTO quizData )
    {

        courseRep.insertNewQuiz(courseID,quizData);
    }
}
