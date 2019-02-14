package com.sms.controller;

import com.sms.model.lookUp.corCategory;
import com.sms.model.lookUp.corLevel;
import com.sms.model.lookUp.corType;
import com.sms.repository.LookupRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/lookup")
public class LookupRes {

    //TODO - Youssef - rename variable to repository
    private LookupRep repositry;

    @Autowired
    public LookupRes(LookupRep repositry) {
        this.repositry = repositry;
    }


    //TODO - Yara - Path should be /instructor/{instructorID}
    //TODO - Yara - should move the function to CourseRes
    //TODO - Yara - rename function to findInstructorCourses
    //TODO - Yara - rename parameter to instructorID


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/corCategory")
    public List<corCategory> findCorCategory() {
        List<corCategory> list =this.repositry.findCorCategory();
        return list;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/corType")
    public List<corType> findCorType() {
        List<corType> list =this.repositry.findCorType();
        return list;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/corLevel")
    public List<corLevel> findCorLevel() {
        List<corLevel> list =this.repositry.findCorLevel();
        return list;
    }

}
