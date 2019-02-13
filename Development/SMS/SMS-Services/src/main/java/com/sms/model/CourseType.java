package com.sms.model;

import java.io.Serializable;

//TODO: Yara - rename Class to CourseVTO - remember to change model in Angular too
//TODO: Yara - move Class to /model/course/
public class CourseType implements Serializable {

    private  int id;
    //TODO: Yara - rename Variable to name - remember to change model in Angular too
    private String labelEN;

    public CourseType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabelEN() {
        return labelEN;
    }

    public void setLabelEN(String labelEN) {
        this.labelEN = labelEN;
    }

    @Override
    public String toString() {
        return "CourseType{" +
                "id=" + id +
                ", labelEN='" + labelEN + '\'' +
                '}';
    }
}
