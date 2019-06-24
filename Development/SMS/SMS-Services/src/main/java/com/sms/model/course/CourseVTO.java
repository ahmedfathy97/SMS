package com.sms.model.course;

import java.io.Serializable;
import java.util.Date;

public class CourseVTO implements Serializable {

    private  int id;
    //private String name;
    private  String courseName;
    private  String imagePath;
    private int  duration ;
    private Date startDate ;
    private Date endDate ;
    private String corCategory ;
    private String corType ;
    private String corLevel;
    private String instructorName;
    private int    studentNum;
    private String description ;
    private int instructorID;

    public CourseVTO() {
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCorCategory() {
        return corCategory;
    }

    public void setCorCategory(String corCategory) {
        this.corCategory = corCategory;
    }

    public String getCorType() {
        return corType;
    }

    public void setCorType(String corType) {
        this.corType = corType;
    }

    public String getCorLevel() {
        return corLevel;
    }

    public void setCorLevel(String corLevel) {
        this.corLevel = corLevel;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}

