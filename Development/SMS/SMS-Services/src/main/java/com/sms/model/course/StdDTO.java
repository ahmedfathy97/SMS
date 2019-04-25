package com.sms.model.course;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StdDTO implements Serializable {
    private int id;
    private String fullName;
    private boolean isAttend;
    private int midTermOne;
    private int semiFinal;
    private int midTermTwo;
    private int finalGrd;
    private Date attendanceDate ;


    public StdDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean getIsAttend() {
        return isAttend;
    }

    public void setIsAttend(boolean attend) {
        isAttend = attend;
    }

    public int getMidTermOne() {
        return midTermOne;
    }

    public void setMidTermOne(int midTermOne) {
        this.midTermOne = midTermOne;
    }

    public int getSemiFinal() {
        return semiFinal;
    }

    public void setSemiFinal(int semiFinal) {
        this.semiFinal = semiFinal;
    }

    public int getMidTermTwo() {
        return midTermTwo;
    }

    public void setMidTermTwo(int midTermTwo) {
        this.midTermTwo = midTermTwo;
    }

    public int getFinalGrd() {
        return finalGrd;
    }

    public void setFinalGrd(int finalGrd) {
        this.finalGrd = finalGrd;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @Override
    public StdDTO clone()  {
        StdDTO data = new StdDTO();
        data.id = this.id;
        data.fullName = this.fullName;
        data.isAttend = this.isAttend;
        data.attendanceDate = this.attendanceDate;
        return data ;
    }

    @Override
    public String toString() {
        return "\nStdDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", isAttend=" + isAttend +
//                ", midTermOne=" + midTermOne +
//                ", semiFinal=" + semiFinal +
//                ", midTermTwo=" + midTermTwo +
//                ", finalGrd=" + finalGrd +
                ", attendanceDate=" + attendanceDate +
                '}';
    }
}
