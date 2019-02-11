package com.sms.controller;

import com.sms.model.CorDetails;
import com.sms.repository.CourseRep;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/course")

public class CourseRes {
    private CourseRep repository;
    @POST
    @Path("/mainDetails")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCourseData(CorDetails details){
        repository.addCourseData(details);
    }
}
