package com.sms.model.course;

public class ExamInformationVTO {
    private String examName ;
    private int grade ;
    private int numberofstudentanswers ;

    public ExamInformationVTO() {
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getNumberofstudentanswers() {
        return numberofstudentanswers;
    }

    public void setNumberofstudentanswers(int numberofstudentanswers) {
        this.numberofstudentanswers = numberofstudentanswers;
    }
}
