package com.sms.model.course;

import java.util.Date;

public class CourseLecturesVTO {

    private int lectureID;
    private String lectureTitle;
    private Date date ;
    public CourseLecturesVTO() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLectureID() {
        return lectureID;
    }

    public void setLectureID(int lectureID) {
        this.lectureID = lectureID;
    }

    public String getLectureTitle() {
        return lectureTitle;
    }

    public void setLectureTitle(String lectureTitle) {
        this.lectureTitle = lectureTitle;
    }
}
