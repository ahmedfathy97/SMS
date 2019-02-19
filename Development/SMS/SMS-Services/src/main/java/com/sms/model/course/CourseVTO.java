package com.sms.model.course;

import java.io.Serializable;

public class CourseVTO implements Serializable {

    private  int id;
    private String name;

    public CourseVTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CourseVTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
