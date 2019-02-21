package com.sms.controller;

import com.sms.model.AttendanceDTO;
import com.sms.model.CorDetails;
import com.sms.model.course.CourseVTO;
import com.sms.model.course.QuizDTO;
import com.sms.model.course.StdDTO;
import com.sms.model.CorDetails;
import com.sms.repository.CourseRep;
import com.sms.service.AttendanceSer;
import com.sms.repository.GradeRep;
import com.sms.service.CourseSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/course")
public class CourseRes {
    private AttendanceSer attendance ;

    @Autowired
    private CourseRep repository;
    @Autowired
    public CourseRes(AttendanceSer attendance) {
        this.attendance = attendance;
    }
    private CourseSer courseSer ;
    private GradeRep gradeRepository;
    @Autowired
    public CourseRes(CourseRep repository ,CourseSer courseSer, GradeRep gradeRepository) {
        this.courseSer = courseSer;
        this.gradeRepository = gradeRepository;
        this.repository =repository ;
    }

    //    public CourseRes(GradeRep gradeRepository) {
//        this.gradeRepository = gradeRepository;
//    }

    @POST
    //TODO: Youssef - rename Path to / only
    @Path("/mainDetails")
    @Consumes(MediaType.APPLICATION_JSON)
    //TODO: Youssef - rename function to createNewCourse
    public void addCourseData(CorDetails details){
        repository.addCourseData(details);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/students")
    public List<StdDTO> findCourseStudents(@PathParam("courseID") int courseID) {
        return this.repository.findAllCourseStudents(courseID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/grade")
    public List<StdDTO> getCourseGrades(@PathParam("courseID") int courseID){
           List<StdDTO> list =this.gradeRepository.findCourseGrades(courseID);
        return list;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/instructor/{instructorID}")
    public List<CourseVTO> findInstructorCourses(@PathParam("instructorID") int instructorID) {
        List<CourseVTO> list =this.repository.findAllInstructorCourses(instructorID);
        return list;
    }


    @POST
    @Path("{courseID}/quiz")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createQuiz(@PathParam("courseID") int courseID ,QuizDTO quizData )
    {
        courseSer.createQuiz(courseID,quizData);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/attend")
    public List<AttendanceDTO> getCourseAttendance (@PathParam("courseID") int courseID) {
        System.out.print("Sucessfully");
        List<AttendanceDTO> list =this.attendance.getCourseAttendance(courseID);
        return list ;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/student/{stdID}")
    public List<AttendanceDTO> getStudentAttendance (@PathParam("courseID") int courseID ,@PathParam("stdID") int stdID) {
        System.out.print("Sucessfully");
        List<AttendanceDTO> list =this.attendance.getStudentAttendance(courseID , stdID);
        return list ;
    }
}
