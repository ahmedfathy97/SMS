package com.sms.controller;

import com.sms.data.CourseGrd;
import com.sms.data.StdDto;
import com.sms.repository.GradeRep;
import com.sms.service.GradeSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/Coursegrd")
public class CoursegrdRes {
    private GradeSer service;

    private GradeRep repositry;

    @Autowired
    public CoursegrdRes(GradeSer service ,GradeRep repositry) {this.service = service; this.repositry = repositry; }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/StdName/{courseID}")
    //TODO: courseID should be Path Parameter
    public List<StdDto> findStdName(@PathParam("courseID") int courseID) {
        List<StdDto> list =this.repositry.findStdByCorID(courseID);
        return list;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("stdGrd/{courseID}")
    public void addStudentGrd(@PathParam("courseID") int courseID, List<StdDto> students){
        this.service.insertStudentGrds(courseID,students);
        System.out.print("Data Recieved Sucessfully");
        System.out.print(students.toString());


    }


}
