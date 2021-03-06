package com.sms.model.course.quiz;

import java.util.Date;

public class QuizInformationVTO {
    String quizName ;
    int grade ;
    Date startDate;
    Date finishDate ;
    int numberofStudentsAnswers ;

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

    public int getNumberofStudentsAnswers() {
        return numberofStudentsAnswers;
    }

    public void setNumberofStudentsAnswers(int numberofStudentsAnswers) {
        this.numberofStudentsAnswers = numberofStudentsAnswers;
    }
}
