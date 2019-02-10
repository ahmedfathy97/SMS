package com.sms.model;

import java.io.Serializable;

public class CourseType implements Serializable {

    private  int id;
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
