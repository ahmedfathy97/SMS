package com.sms.model.course.quiz;

public class ModelAnswerVTO {

    private  int questionID ;
    private  String modelAnswer ;
    private  int questionGrade ;


    public ModelAnswerVTO() {
    }

    public int getQuestionGrade() {
        return questionGrade;
    }

    public void setQuestionGrade(int questionGrade) {
        this.questionGrade = questionGrade;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getModelAnswer() {
        return modelAnswer;
    }

    public void setModelAnswer(String modelAnswer) {
        this.modelAnswer = modelAnswer;
    }
}
