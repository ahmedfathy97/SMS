package com.sms.controller;

import com.sms.model.course.LectureDTO;
import com.sms.repository.lectureRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/lecture")
public class LectureRes {
    private lectureRep repository;
    @Autowired
    public LectureRes(lectureRep repository) {
        this.repository = repository;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createNewLecture(LectureDTO data){
        repository.insertNewLecture(data);
    }
}
