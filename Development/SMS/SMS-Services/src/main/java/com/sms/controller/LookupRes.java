package com.sms.controller;

import com.sms.model.CourseType;
import com.sms.repository.LookupRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/lookup")
public class LookupRes {

    private LookupRep repositry;

    @Autowired
    public LookupRes(LookupRep repositry) {
        this.repositry = repositry;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/CourseType")
    public List<CourseType> findData() {
        List<CourseType> list =this.repositry.findCourseByInstID(2);
        return list;
    }

}
