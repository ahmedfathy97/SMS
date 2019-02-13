package com.sms.data;

import java.util.List;

//TODO: Hala - no need for this Class Remove it - remember to change model in Angular too
public class CourseGrd {
    private  int corId;
    private List<StdDto> students;


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
