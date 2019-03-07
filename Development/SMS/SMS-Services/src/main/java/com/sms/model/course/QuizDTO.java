package com.sms.model.course;

import java.util.Date;

public class QuizDTO {

    String quizName ;
    int grade ;
    Date startDate;
    Date finishDate ;

    boolean closeAuto  ;

    public boolean iscloseAuto() {
        return closeAuto;
    }

    public void setcloseAuto(boolean closeAuto) {
        this.closeAuto = closeAuto;
    }


    public QuizDTO() {
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
    @Override
    public String toString() {
        return "QuizDTO{" +
                "quizName='" + quizName + '\'' +
                ", grade=" + grade +
                ", autoClose=" + closeAuto +
                '}';
    }

}
