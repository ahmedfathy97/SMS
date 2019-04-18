package com.sms.controller;


import com.sms.model.AttendanceDTO;
import com.sms.model.course.Announcement;
import com.sms.service.AnnouncementSer;
import com.sms.service.AttendanceSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/announcement")
public class AnnouncementRes {
    private AnnouncementSer announcementSer;

    @Autowired
    public AnnouncementRes(AnnouncementSer announcementSer) {
        this.announcementSer = announcementSer;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/new")
    public void createAttendanceSheet(@PathParam("courseID") int courseID, Announcement announcement) {
        System.out.print("Data Recieved Sucessfully");
        System.out.print(announcement.toString());
        this.announcementSer.createAnnouncement(courseID, announcement);
    }

}
