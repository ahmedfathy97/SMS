package com.sms.service;

import com.sms.model.course.Announcement;
import com.sms.repository.AnnouncementRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementSer {
    private AnnouncementRep announcementRep ;

    @Autowired
    public AnnouncementSer(AnnouncementRep announcementRep) {
        this.announcementRep = announcementRep;
    }

    public void createAnnouncement (int courseID , Announcement announcement)
    {

        announcementRep.createAnnouncement(courseID,announcement);
    }
}
