package com.sms.model;

import com.sms.model.course.StdDTO;

import java.util.Date;
import java.util.List;

//TODO: Yara - rename CLass to AttendanceDTO - remember to change model in Angular too
public class AttendanceDTO {
    //TODO: Yara - no need for course As It's not used
    //private String course;
    //TODO: Yara - should be attendanceDate - remember to change model in Angular too
    private Date attendanceData;
    //TODO: Yara - should be students - remember to change model in Angular too
    private List<StdDTO> students;

    public AttendanceDTO() {
    }


//    public String getCourse() {
//        return course;
//    }
//
//    public void setCourse(String course) {
//        this.course = course;
//    }

    public Date getAttendanceData() {
        return attendanceData;
    }

    public void setAttendanceData(Date attendanceData) {
        this.attendanceData = attendanceData;
    }

    public List<StdDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StdDTO> students) {
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
