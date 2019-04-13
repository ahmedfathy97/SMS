package com.sms.model.course;

public class CourseLecturesVTO {

    private int lectureID;
    private String lectureTitle;

    public CourseLecturesVTO() {
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
