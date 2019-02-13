package com.sms.controller;

import com.sms.model.CorDetails;
import com.sms.repository.CourseRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/course")
public class CourseRes {
    @Autowired
    private CourseRep repository;

    @POST
    //TODO: Youssef - rename Path to / only
    @Path("/mainDetails")
    @Consumes(MediaType.APPLICATION_JSON)
    //TODO: Youssef - rename function to createNewCourse
    public void addCourseData(CorDetails details){
        repository.addCourseData(details);
    }
}
