package com.sms.model.course.quiz;

public class QuestionEvaluate {
    private boolean isCorrect ;
    private int studentGrade ;

    public QuestionEvaluate() {
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }
}
