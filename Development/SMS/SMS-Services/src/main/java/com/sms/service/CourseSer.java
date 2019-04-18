package com.sms.service;

import com.sms.model.authorization.AuthRoles;
import com.sms.model.course.Announcement;
import com.sms.model.course.CourseLecturesVTO;
import com.sms.model.course.CourseQuizesVTO;
import com.sms.model.course.CourseVTO;
import com.sms.model.course.quiz.QuizDTO;
import com.sms.model.user.UserVTO;
import com.sms.repository.CourseRep;
import com.sms.repository.QuizRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.PathParam;
import java.util.ArrayList;
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


    public List<CourseQuizesVTO> getCourseQuizes(int courseID)
    {
        List<CourseQuizesVTO> courseQuizesVTOList =  courseRep.getCourseQuizes(courseID);
        return courseQuizesVTOList ;
    }

    public List<CourseLecturesVTO> getCourseLectures(int courseID)
    {
        List<CourseLecturesVTO> courseLecturesVTOList =courseRep.getCourseLectures(courseID) ;
        return courseLecturesVTOList ;
    }
    public List<CourseVTO> findAllCourses(UserVTO currentUser){
        List<CourseVTO> CourseVTOList = new ArrayList<>();
        if(currentUser.getRoleIDs().contains(AuthRoles.INSTRUCTOR.getID()))
            CourseVTOList = courseRep.findAllStudentCourse(currentUser.getId());
        else if (currentUser.getRoleIDs().contains(AuthRoles.STUDENT.getID()))
            CourseVTOList =courseRep.findAllStudentCourse(currentUser.getId());
        return CourseVTOList;


    }


    public void createAnnouncement (int courseID , Announcement announcement)
    {

        courseRep.createAnnouncement(courseID,announcement);
    }



    public List<Announcement> getCourseAnnouncments(int courseID)
    {
        List<Announcement> announcementList = courseRep.getCourseAnnouncments(courseID) ;
        return  announcementList ;
    }


//    public void createAnnouncement (int courseID , Announcement announcement)
//    {
//
//        courseRep.createAnnouncement(courseID,announcement);
//    }



//    public List<Announcement> getCourseAnnouncments(int courseID)
//    {
//        List<Announcement> announcementList = courseRep.getCourseAnnouncments(courseID) ;
//        return  announcementList ;
//    }



}
