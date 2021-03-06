package com.sms.model.course;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;

public class LectureDTO implements Serializable {
    private String  title ;
    private Date date ;
    private String videoUrl;
    private String description ;

    public LectureDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
