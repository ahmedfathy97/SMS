package com.sms.model.course;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//TODO: Hala - rename CLass to StdDTO - remember to change model in Angular too
//TODO: Hala - move to model/course/
public class StdDTO implements Serializable {
    private int id;
    private String fullName;
    private boolean isAttend;
    private int midTermOne;
    private int semiFinal;
    private int midTermTwo;
    private int finalGrd;


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

    @Override
    public String toString() {
        return "StdDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", isAttend=" + isAttend +
                ", midTermOne=" + midTermOne +
                ", semiFinal=" + semiFinal +
                ", midTermTwo=" + midTermTwo +
                ", finalGrd=" + finalGrd +
                '}';
    }
}
