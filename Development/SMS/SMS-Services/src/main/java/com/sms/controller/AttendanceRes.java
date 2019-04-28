package com.sms.controller;

import com.sms.model.AttendanceDTO;

import com.sms.service.AttendanceSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/attendance")
public class AttendanceRes {
    //TODO: Yara - should be AttendanceService
    private AttendanceSer attendanceSer;
   // private AttendanceRep repository ;
    //private GradeRep rep ;
    @Autowired
    public AttendanceRes(AttendanceSer attendanceSer) {
        this.attendanceSer = attendanceSer;
    }




    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/new")
    public void createAttendanceSheet(@PathParam("courseID") int courseID, AttendanceDTO attendanceDate ,
                                      @QueryParam("isUpdate") boolean isUpdate)
    {
        System.out.print("Data Recieved Sucessfully");
        System.out.print(attendanceDate.toString());
        this.attendanceSer.createSheet(courseID, attendanceDate , isUpdate );
    }



}

