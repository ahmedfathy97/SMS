package com.sms.model.authorization;

public enum AuthViews {
    USER_LIST(1),
    ADD_ATTENDANCE(3),
    ADD_GRADE(2);
    private int id;

    AuthViews(int id){
        this.id = id;
    }

    public int getID(){ return id; }
}
