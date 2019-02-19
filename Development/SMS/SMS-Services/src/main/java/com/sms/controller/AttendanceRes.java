package com.sms.controller;
import com.sms.model.AttendanceDTO;
import com.sms.service.AttendanceSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/attendance")
public class AttendanceRes {
    //TODO: Yara - should be AttendanceService
    private AttendanceSer attend;

    @Autowired
    public AttendanceRes(AttendanceSer attend) {
        this.attend = attend;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{courseID}")
    public void createAttendanceSheet(@PathParam("courseID") int courseID, AttendanceDTO attendanceDate) {
        System.out.print("Data Recieved Sucessfully");
        System.out.print(attendanceDate.toString());
        this.attend.createSheet(courseID, attendanceDate);
    }
}

