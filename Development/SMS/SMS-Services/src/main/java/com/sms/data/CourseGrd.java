package com.sms.data;

import java.util.ArrayList;
import java.util.List;

public class CourseGrd {
    private  int corId;
    private String stdName;
    private  int midTermOne;
    private  int semiFinal;
    private  int midTermTwo;
    private  int Final;
//    List<StdDto> data;
//
//    public List<StdDto> getData() {
//        return data;
//    }
//
//    public void setData(List<StdDto> data) {
//        this.data = data;
//        data.add(midTermOne);
//    }

    public CourseGrd() {
    }


    public int getCorId() {
        return corId;
    }

    public void setCorId(int corId) {
        this.corId = corId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
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
}
