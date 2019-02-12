package com.sms.data;

import java.util.ArrayList;
import java.util.List;

public class CourseGrd {
    private  int corId;
    private List<StdDto> students;
//    private String stdName;
//    private  int midTermOne;
//    private  int semiFinal;
//    private  int midTermTwo;
//    private  int Final;


    public CourseGrd() {
    }


    public int getCorId() {
        return corId;
    }

    public void setCorId(int corId) {
        this.corId = corId;
    }

    public List<StdDto> getStudents() {
        return students;
    }

    public void setStudents(List<StdDto> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "CourseGrd{" +
                "corId=" + corId +
                ", students=" + students +
                '}';
    }
}
