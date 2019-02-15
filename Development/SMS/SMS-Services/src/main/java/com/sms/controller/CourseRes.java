package com.sms.controller;

import com.sms.model.course.CourseVTO;
import com.sms.model.course.StdDTO;
import com.sms.model.CorDetails;
import com.sms.repository.CourseRep;
import com.sms.repository.GradeRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/course")
public class CourseRes {
    @Autowired
    private CourseRep repository;
    @Autowired
    private GradeRep gradeRepository;
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
    //TODO: Hala - Path should be /{courseID}/students
    //TODO: Hala - Service should be moved to CourseRes
    @Path("/{courseID}/students")
    //TODO: Hala - function should be findCourseStudents
    public List<StdDTO> findCourseStudents(@PathParam("courseID") int courseID) {
        return this.repository.findAllCourseStudents(courseID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/grade")
    public List<StdDTO> getCourseGrades(@PathParam("courseID") int courseID){
        return this.gradeRepository.findCourseGrades(courseID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/instructor/{instructorID}")
    public List<CourseVTO> findInstructorCourses(@PathParam("instructorID") int instructorID) {
        List<CourseVTO> list =this.repository.findAllInstructorCourses(instructorID);
        return list;
    }
}
