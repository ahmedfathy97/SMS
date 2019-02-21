package com.sms.model;

import com.sms.model.course.StdDTO;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

//TODO: Yara - should be moved to /model/course/
public class AttendanceDTO {
    //TODO: Yara - should be attendanceDate - remember to change model in Angular too
    private Date attendanceData;
    private List<StdDTO> students;

    public AttendanceDTO() {
    }


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
                "attendanceData=" + attendanceData +
                ", students=" + students +
                '}';
    }
}
