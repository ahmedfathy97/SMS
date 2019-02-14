package com.sms.model;

import com.sms.data.StdDto;

import java.util.Date;
import java.util.List;

//TODO: Yara - rename CLass to AttendanceDTO - remember to change model in Angular too
public class AttendanceDTO {
    //TODO: Yara - no need for course As It's not used
    //private String course;
    //TODO: Yara - should be attendanceDate - remember to change model in Angular too
    private Date attendanceData;
    //TODO: Yara - should be students - remember to change model in Angular too
    private List<StdDto> students;

    public AttendanceDTO() {
    }


//    public String getCourse() {
//        return course;
//    }
//
//    public void setCourse(String course) {
//        this.course = course;
//    }

    public Date getDate() {
        return attendanceData;
    }

    public void setDate(Date attendanceData) {
        this.attendanceData = attendanceData;
    }

    public List<StdDto> getStudents() {
        return students;
    }

    public void setStudents(List<StdDto> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "AttendanceDTO{" +

                ", date=" + attendanceData +
//                ", stdlist=" + Arrays.toString(stdlist) +
                '}';
    }
}
