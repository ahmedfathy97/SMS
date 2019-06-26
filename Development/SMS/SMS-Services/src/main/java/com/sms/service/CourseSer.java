package com.sms.service;

import com.sms.model.authorization.AuthRoles;
import com.sms.model.course.*;
import com.sms.model.course.quiz.QuizDTO;
import com.sms.model.user.UserVTO;
import com.sms.repository.CourseRep;
import com.sms.repository.GradeRep;
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
    private GradeRep repository;


    @Autowired
    public CourseSer(CourseRep courseRep , QuizRep quizRep,GradeRep  repository) {
        this.courseRep = courseRep;
        this.quizRep = quizRep ;
        this.repository = repository;
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

    public List<CourseExamsVTO> getCourseExams(int courseID)
    {
        List<CourseExamsVTO> courseQuizesVTOList =  courseRep.getCourseExams(courseID);
        return courseQuizesVTOList ;
    }

    public CourseResultSet getCourseLectures(int courseID,int pageNum)
    {
        CourseResultSet resultSet = new CourseResultSet();
        List<LectureVTO> lectureVTOList =courseRep.getCourseLectures(courseID,pageNum) ;
        resultSet.setLectureList(lectureVTOList);
        int count = courseRep.findAllLectureCount(courseID);
        resultSet.setTotalRecords(count);
        return resultSet;
    }
    public CourseResultSet findALLCourses(int pageNum){
        CourseResultSet resultSet = new CourseResultSet();

        List<CourseVTO> courseVTOList =  courseRep.findALLCourses(pageNum);
        resultSet.setList(courseVTOList);

        int count = courseRep.findALLCoursesCount();
        resultSet.setTotalRecords(count);


        return resultSet;
    }
    public  CourseResultSet findCourseGrades(int courseID ,int pageNum){
        CourseResultSet resultSet = new CourseResultSet();
        List<StdDTO> studentLis=repository.findCourseGrades(courseID,pageNum);
        resultSet.setStudentLis(studentLis);
        int count =repository.findALLGradeCount( courseID);
        resultSet.setTotalRecords(count);
        return resultSet;


    }
    public CourseResultSet myCourses(UserVTO currentUser,int pageNum){
        List<CourseVTO> courseVTOList = new ArrayList<>();
        if(currentUser.getRoleIDs().contains(AuthRoles.INSTRUCTOR.getID()))
            courseVTOList = courseRep.findAllInstructorCourses(currentUser.getId(),pageNum);
        else if (currentUser.getRoleIDs().contains(AuthRoles.STUDENT.getID()))
            courseVTOList =courseRep.findAllStudentCourse(currentUser.getId(),pageNum);

        CourseResultSet resultSet = new CourseResultSet();
        resultSet.setList(courseVTOList);

        int count = courseRep.findALLCoursesCount();
        resultSet.setTotalRecords(count);

        return resultSet;


    }


    public void createAnnouncement (UserVTO currentUser,int courseID , Announcement announcement) throws Exception {
        boolean isInstructor = this.courseRep.isInstructor(currentUser.getId(), courseID);
        if (!isInstructor)
            throw new Exception("Only Course Instructor can add Announcement");

        courseRep.createAnnouncement(courseID,announcement);
    }



    public CourseResultSet getCourseAnnouncments(int courseID , int pageNum)
    {
        CourseResultSet resultSet = new CourseResultSet();
        List<Announcement> announcementList = courseRep.getCourseAnnouncments(courseID , pageNum) ;
        resultSet.setAnnounclist(announcementList);

        int count = courseRep.findALLAnnouncementCount();
        resultSet.setTotalRecords(count);

        return resultSet  ;
    }

//    public List<Announcement> getCourseAnnouncments(int courseID )
//    {
//        List<Announcement> announcementList = courseRep.getCourseAnnouncments(courseID) ;
//        return  announcementList ;
//    }

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
