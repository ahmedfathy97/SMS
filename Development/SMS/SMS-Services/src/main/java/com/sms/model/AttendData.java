package com.sms.model;

import com.sms.data.StdDto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AttendData {
    private String course;
    private Date date;
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
