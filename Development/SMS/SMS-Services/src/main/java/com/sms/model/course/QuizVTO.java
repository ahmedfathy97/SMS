package com.sms.model.course;

public class QuizVTO {
    private int quizId;
    private String quizName;
    private int stdScore;
    private int totalScore;

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public int getStdScore() {
        return stdScore;
    }

    public void setStdScore(int stdScore) {
        this.stdScore = stdScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
