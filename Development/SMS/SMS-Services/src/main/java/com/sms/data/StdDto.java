package com.sms.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StdDto  implements Serializable {
    private  int id;
    private String fullName;
    private  int midTermOne;
    private  int semiFinal;
    private  int midTermTwo;
    private  int Final;
//    private boolean isAttend;



    public StdDto() {
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

    public int getFinal() {
        return Final;
    }

    public void setFinal(int aFinal) {
        Final = aFinal;
    }

    @Override
    public String toString() {
        return "StdDto{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", midTermOne=" + midTermOne +
                ", semiFinal=" + semiFinal +
                ", midTermTwo=" + midTermTwo +
                ", Final=" + Final +
                '}';
    }
}
