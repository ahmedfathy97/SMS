package com.sms.model;

import com.sms.model.course.StdDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//TODO: Yara - should be moved to /model/course/
public class AttendanceDTO {
    //TODO: Yara - should be attendanceDate - remember to change model in Angular too
    private Date attendanceData;
    private List<StdDTO> students = new ArrayList<>();
    private int attendCount ;
    private int totalStd ;

    public int getTotalStd() {
        return totalStd;
    }

    public void setTotalStd(int totalStd) {
        this.totalStd = totalStd;
    }

    public AttendanceDTO() {
    }


    public int getAttendCount() {
        return attendCount;
    }

    public void setAttendCount(int attendCount) {
        this.attendCount = attendCount;
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
        return "\nAttendanceDTO{" +
                "attendanceData=" + attendanceData +
                ", students=" + students +
                '}';
    }
}
