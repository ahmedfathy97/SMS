package com.sms.controller;
import com.sms.model.course.Announcement;
import com.sms.service.AnnouncementSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/announcment")
public class AnnouncementRes {
    private AnnouncementSer announcementSer;

    @Autowired
    public AnnouncementRes(AnnouncementSer announcementSer) {
        this.announcementSer = announcementSer;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/new")
    public void createAnnouncement(@PathParam("courseID") int courseID, Announcement announcement) {
        this.announcementSer.createAnnouncement(courseID, announcement);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/announcmentList")
    public List<Announcement> getCourseAnnouncments(@PathParam("courseID") int courseID)
    {
        List<Announcement> announcementList =announcementSer.getCourseAnnouncments(courseID) ;
        return announcementList ;
    }





}
