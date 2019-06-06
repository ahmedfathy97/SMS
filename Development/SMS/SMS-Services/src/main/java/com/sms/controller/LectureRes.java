package com.sms.controller;

import com.sms.model.annotation.Authenticated;
import com.sms.model.attachment.File;
import com.sms.model.authorization.AuthViews;
import com.sms.model.course.LectureDTO;
import com.sms.repository.lectureRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/lecture")
public class LectureRes {
    private lectureRep repository;

    @Autowired
    public LectureRes(lectureRep repository) {
        this.repository = repository;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{lecID}")
    @Authenticated(views = {AuthViews.LECTURE_DETAILS})
    public LectureDTO listFiles(@PathParam("lecID") int lecID)
     {
        LectureDTO lecture = this.repository.getLecture(lecID);
        return lecture;

    }
}
