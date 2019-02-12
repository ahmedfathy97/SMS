package com.sms.controller;

import com.sms.model.AttendData;
import com.sms.service.AttendSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/attendance")
public class AttendRes {
    private AttendSer attend ;

    @Autowired
    public AttendRes(AttendSer attend) {
        this.attend = attend;
    }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Path("/student/{courseID}")
        public void insertAttendanceDetails (@PathParam("courseID") int courseID ,AttendData data) {
            System.out.print("Data Recieved Sucessfully");
            System.out.print(data.toString());
            this.attend.insertSheetDetails(courseID,data);
        }
    }

