package com.sms.service;

import com.sms.model.course.Announcement;
import com.sms.repository.AnnouncementRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.PathParam;
import java.util.List;

@Service
public class AnnouncementSer {
    private AnnouncementRep announcementRep ;

    @Autowired
    public AnnouncementSer(AnnouncementRep announcementRep) {
        this.announcementRep = announcementRep;
    }


}
