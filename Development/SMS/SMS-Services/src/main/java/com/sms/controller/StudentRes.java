package com.sms.controller;

import com.sms.repository.StudentRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
@Path("/student")
public class StudentRes {
    private StudentRep repository;
    @Autowired
    public StudentRes(StudentRep repository) {
        this.repository = repository;
    }





    @POST
    @Path("/enroll/{courseID}")
    public void enrollStudentByID(@PathParam("courseID") int courseID){
        int studentid=2;
        repository.insertStudent(courseID,studentid);

    }

}
