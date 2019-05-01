package com.sms.service;

import com.sms.model.authorization.AuthRoles;
import com.sms.model.course.*;
import com.sms.model.course.quiz.QuizDTO;
import com.sms.model.user.UserVTO;
import com.sms.repository.CourseRep;
import com.sms.repository.QuizRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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


    public List<StdDTO> findAllCourseStudents(int corID, String gradeType, String attendanceDate){
        List<StdDTO> students = new ArrayList<>();
        if(gradeType != null){
            students=this.courseRep.findAllTypeGrade(corID)   ;
        }else if (attendanceDate != null && !attendanceDate.isEmpty()){
            students = this.courseRep.findAllStudentsAttendance(corID , attendanceDate);
//            if(students.size()==0)
//                students = this.courseRep.findAllCourseStudents(corID);
        } else
            students = this.courseRep.findAllCourseStudents(corID);
        return students;
    }


    public int createQuiz(int courseID ,QuizDTO quizData )
    {

        return courseRep.insertNewQuiz(courseID,quizData);
    }


    public List<CourseQuizesVTO> getCourseQuizes(int courseID)
    {
        List<CourseQuizesVTO> courseQuizesVTOList =  courseRep.getCourseQuizes(courseID);
        return courseQuizesVTOList ;
    }

    public List<LectureVTO> getCourseLectures(int courseID)
    {
        List<LectureVTO> lectureVTOList =courseRep.getCourseLectures(courseID) ;
        return lectureVTOList;
    }
    public CourseResultSet findALLCourses(){
        List<CourseVTO> courseVTOList = new ArrayList<>();
        courseVTOList = courseRep.findALLCourses();
        CourseResultSet resultSet = new CourseResultSet();
        resultSet.setList(courseVTOList);
        return resultSet;
    }
    public CourseResultSet myCourses(UserVTO currentUser){
        List<CourseVTO> courseVTOList = new ArrayList<>();
        if(currentUser.getRoleIDs().contains(AuthRoles.INSTRUCTOR.getID()))
            courseVTOList = courseRep.findAllInstructorCourses(currentUser.getId());
        else if (currentUser.getRoleIDs().contains(AuthRoles.STUDENT.getID()))
            courseVTOList =courseRep.findAllStudentCourse(currentUser.getId());

        CourseResultSet resultSet = new CourseResultSet();
        resultSet.setList(courseVTOList);
        return resultSet;


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
