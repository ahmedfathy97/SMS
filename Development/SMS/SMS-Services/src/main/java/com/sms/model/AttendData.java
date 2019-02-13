package com.sms.model;

import com.sms.data.StdDto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

//TODO: Yara - rename CLass to AttendanceDTO - remember to change model in Angular too
public class AttendData {
    //TODO: Yara - no need for course As It's not used
    private String course;
    //TODO: Yara - should be attendanceDate - remember to change model in Angular too
    private Date date;
    //TODO: Yara - should be students - remember to change model in Angular too
    private List<StdDto> stdList;

    public AttendData() {
    }


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<StdDto> getStdList() {
        return stdList;
    }

    public void setStdList(List<StdDto> stdList) {
        this.stdList = stdList;
    }

    @Override
    public String toString() {
        return "AttendData{" +
                "course='" + course + '\'' +
                ", date=" + date +
//                ", stdlist=" + Arrays.toString(stdlist) +
                '}';
    }
}
