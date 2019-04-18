package com.sms.model.course;

import java.util.Date;

public class Announcement {
    String title ;
    String content ;
    Date announcmentDate ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAnnouncmentDate() {
        return announcmentDate;
    }

    public void setAnnouncmentDate(Date announcmentDate) {
        this.announcmentDate = announcmentDate;
    }
}
