package com.sms.model;

import java.util.Date;

public class AssignmentDTO {
    private int stdID;
    private String firstName;
    private String lastName;
    private Date answerDate;
    private int answerID;
    private int assignID;
    private int dueDate;

    public int getStdID() {
        return stdID;
    }

    public void setStdID(int stdID) {
        this.stdID = stdID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public int getAssignID() {
        return assignID;
    }

    public void setAssignID(int assignID) {
        this.assignID = assignID;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "AssignmentDTO{" +
                "stdID=" + stdID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", answerDate=" + answerDate +
                ", answerID=" + answerID +
                ", assignID=" + assignID +
                ", dueDate=" + dueDate +
                '}';
    }
}
