package com.sms.model.course.quiz;

public class QuestionVTO {
    private int id ;
    private int questionTypeID ;

    private String question ;
    private String answer1 ;
    private String answer2 ;
    private String answer3 ;
    private String answer4 ;

    public QuestionVTO() {
    }



    public int getQuestionTypeID() {
        return questionTypeID;
    }

    public void setQuestionTypeID(int questionTypeID) {
        this.questionTypeID = questionTypeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }
}
