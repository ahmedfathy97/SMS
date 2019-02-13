package com.sms.controller;

import com.sms.model.AttendData;
import com.sms.service.AttendSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/attendance")
//TODO: Yara - Class should be AttendanceRes
public class AttendRes {
    //TODO: Yara - should be attendanceService
    private AttendSer attend;

    @Autowired
    public AttendRes(AttendSer attend) {
        this.attend = attend;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //TODO: Yara - path should be /{courseID}
    @Path("/student/{courseID}")
    //TODO: Yara - function should be createAttendanceSheet
    public void insertAttendanceDetails(@PathParam("courseID") int courseID, AttendData data) {
        System.out.print("Data Recieved Sucessfully");
        System.out.print(data.toString());
        this.attend.insertSheetDetails(courseID, data);
    }
}

