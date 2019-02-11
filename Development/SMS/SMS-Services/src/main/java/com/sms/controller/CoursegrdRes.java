package com.sms.controller;

import com.sms.data.CourseGrd;
import com.sms.data.StdDto;
import com.sms.repository.GradeRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/Coursegrd")
public class CoursegrdRes {
    private GradeRep repositry;

    @Autowired
    public CoursegrdRes(GradeRep repositry) {this.repositry = repositry; }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/StdName/{courseID}")
    //TODO: courseID should be Path Parameter
    public List<StdDto> findStdName(@PathParam("courseID") int courseID) {
        List<StdDto> list =this.repositry.findStdByCorID(courseID);
        return list;
    }


}
