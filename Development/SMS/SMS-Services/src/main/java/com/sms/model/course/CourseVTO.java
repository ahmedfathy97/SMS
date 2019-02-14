package com.sms.model.course;

import java.io.Serializable;

//TODO: Yara - rename Class to CourseVTO - remember to change model in Angular too
//TODO: Yara - move Class to /model/course/
public class CourseVTO implements Serializable {

    private  int id;
    //TODO: Yara - rename Variable to name - remember to change model in Angular too
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
