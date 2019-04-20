package com.sms.controller;

import com.sms.controller.filter.AuthenticationFilter;
import com.sms.model.AttendanceDTO;
import com.sms.model.course.*;
import com.sms.model.course.quiz.QuizDTO;
import com.sms.model.user.UserVTO;
import com.sms.repository.CourseRep;
import com.sms.repository.QuizRep;
import com.sms.service.AttendanceSer;
import com.sms.repository.GradeRep;
import com.sms.service.CourseSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/course")
public class CourseRes {
    private AttendanceSer attendance;
    private CourseRep courseRep;
    private CourseSer courseSer;
    private GradeRep gradeRepository;
    private QuizRep rep;

    @Autowired
    public CourseRes(
            CourseRep repository,
            CourseSer courseSer,
            GradeRep gradeRepository,
            AttendanceSer attendance
            , QuizRep rep) {
        this.courseSer = courseSer;
        this.gradeRepository = gradeRepository;
        this.courseRep = repository;
        this.attendance = attendance;
        this.rep = rep;
    }



    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createNewCourse(CourseDTO details) {
        courseRep.insertNewCourse(details);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/students")
    public List<StdDTO> findCourseStudents(@PathParam("courseID") int courseID) {
        return this.courseRep.findAllCourseStudents(courseID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/grade")
    public List<StdDTO> getCourseGrades(@PathParam("courseID") int courseID) {
        List<StdDTO> list = this.gradeRepository.findCourseGrades(courseID);
        return list;
    }


//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{instructorID}/courses")
//    public List<CourseVTO> findInstructorCourses(@PathParam("instructorID") int instructorID) {
//        List<CourseVTO> list = this.courseRep.findAllInstructorCourses(instructorID);
//        return list;
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<CourseVTO> findAllCourses(@Context ContainerRequestContext request) {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
        List<CourseVTO> list = this.courseSer.findAllCourses(currentUser);
        return list;

    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{corID}")
    public CourseVTO viewCourse(@PathParam("corID") int corID) {
        CourseVTO viewData = this.courseRep.findByID(corID);
        return viewData;
    }


    @POST
    @Path("/{courseID}/lecture")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createNewLecture(@PathParam("courseID") int courseID, LectureDTO lectureDTO) {

        courseRep.insertNewLecture(courseID, lectureDTO);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/lectures")

    public List<CourseLecturesVTO> getCourseLectures(@PathParam("courseID") int courseID) {
        List<CourseLecturesVTO> courseLecturesVTOList = courseSer.getCourseLectures(courseID);
        return courseLecturesVTOList;
    }


    @POST
    @Path("/{courseID}/newQuiz")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createQuiz(@PathParam("courseID") int courseID, QuizDTO quizData) {
        courseSer.createQuiz(courseID, quizData);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/quizes")
    public List<CourseQuizesVTO> getCourseQuizes(@PathParam("courseID") int courseID) {
        List<CourseQuizesVTO> courseQuizesVTOList = courseSer.getCourseQuizes(courseID);
        return courseQuizesVTOList;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/attendance")
    public List<AttendanceDTO> getCourseAttendance(@PathParam("courseID") int courseID) {
        System.out.print("Sucessfully");
        List<AttendanceDTO> list = this.attendance.getCourseAttendance(courseID);
        return list;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/student/{stdID}")
    public List<AttendanceDTO> getStudentAttendance(@PathParam("courseID") int courseID, @PathParam("stdID") int stdID) {
        System.out.print("Sucessfully");
        List<AttendanceDTO> list = this.attendance.getStudentAttendance(courseID, stdID);
        return list;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/grade/student/{studentID}")

    public StdDTO getStudentGrades(@PathParam("courseID") int courseID, @PathParam("studentID") int studentID) {
        StdDTO list = this.gradeRepository.findStudentGrades(courseID, studentID);
        return list;

    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/newAnnouncment")
    public void createAnnouncement(@PathParam("courseID") int courseID, Announcement announcement) {
        System.out.print("Data Recieved Sucessfully");
        System.out.print(announcement.toString());
        this.courseSer.createAnnouncement(courseID, announcement);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/announcmentList")
    public List<Announcement> getCourseAnnouncments(@PathParam("courseID") int courseID)
    {
        List<Announcement> announcementList = courseSer.getCourseAnnouncments(courseID) ;
        return announcementList ;
    }



}
