package com.sms.controller;

import com.sms.data.StdDto;
import com.sms.repository.GradeRep;
import com.sms.service.GradeSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

//TODO: Hala - Path should be /grade
//TODO: Hala - Class should be GradeRes
@Path("/Coursegrd")
public class CoursegrdRes {
    //TODO: Hala - variable name should be gradeService
    private GradeSer service;
    //TODO: Hala - Class should be gradeRepository
    private GradeRep repositry;

    @Autowired
    public CoursegrdRes(GradeSer service, GradeRep repositry) {
        this.service = service;
        this.repositry = repositry;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //TODO: Hala - Path should be /{courseID}/students
    //TODO: Hala - Service should be moved to CourseRes
    @Path("/StdName/{courseID}")
    //TODO: Hala - function should be findCourseStudents
    public List<StdDto> findStdName(@PathParam("courseID") int courseID) {
        return this.repositry.findStdByCorID(courseID);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //TODO: Hala - Path should be /{courseID}
    @Path("stdGrd/{courseID}")
    //TODO: Hala - function should be createGradeSheet
    public void addStudentGrd(@PathParam("courseID") int courseID, List<StdDto> students) {
        this.service.insertStudentGrds(courseID, students);
        System.out.print("Data Recieved Sucessfully");
        System.out.print(students.toString());


    }


}
