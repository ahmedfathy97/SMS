package com.sms.model.authorization;

public enum AuthViews {
    USER_LIST(1),
    ADD_GRADE(2),
    ADD_ATTENDANCE(3),
    ADD_ANNOUNCEMENT(4),
    CREATE_LEC(9);
    private int id;

    AuthViews(int id){
        this.id = id;
    }

    public int getID(){ return id; }
}
