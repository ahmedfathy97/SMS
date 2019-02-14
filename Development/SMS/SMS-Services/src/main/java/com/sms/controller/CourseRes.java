package com.sms.controller;

import com.sms.model.CorDetails;
import com.sms.model.course.CourseVTO;
import com.sms.repository.CourseRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/instructor/{instructorID}")
    public List<CourseVTO> findInstructorCourses(@PathParam("instructorID") int instructorID) {
        List<CourseVTO> list =this.repository.findAllInstructorCourses(instructorID);
        return list;
    }
}
