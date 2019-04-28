package com.sms.controller;

import com.sms.controller.filter.AuthenticationFilter;
import com.sms.model.AttendanceDTO;

import com.sms.model.annotation.Authenticated;
import com.sms.model.user.UserVTO;
import com.sms.service.AttendanceSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    @Authenticated()
    public void createAttendanceSheet(@Context ContainerRequestContext request, @PathParam("courseID") int courseID, AttendanceDTO attendanceDate ,
                                      @QueryParam("isUpdate") boolean isUpdate) throws Exception {

        try {
            UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
            System.out.print("Data Recieved Sucessfully");
            System.out.print(attendanceDate.toString());
            this.attendanceSer.createSheet(currentUser, courseID, attendanceDate, isUpdate);
        } catch (Exception e) {
            request.abortWith(Response.status(Response.Status.BAD_REQUEST)
                    .entity("User doesn't have privilege to enter").build());
        }
    }



}

