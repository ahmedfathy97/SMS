package com.sms.model;

import java.io.Serializable;
import java.util.Date;

//TODO: Youssef - rename Class to CourseDTO - remember to change model in Angular too
//TODO: Youssef - move Class to /model/course/
public class CorDetails implements Serializable {
    //TODO: Youssef - rename Class to name - remember to change model in Angular too
    private String  courseName ;
    private int  duration ;
    private Date startDate ;
    private Date endDate ;
    private int categoryID ;
    private int typeID ;
    private int levelID;
    private String description ;

    public CorDetails() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

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

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getLevelID() {
        return levelID;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
