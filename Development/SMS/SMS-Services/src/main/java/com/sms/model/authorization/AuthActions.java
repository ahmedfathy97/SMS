package com.sms.model.authorization;

public enum AuthActions {
    COR_ADD_GRADE(1),
    COR_ADD_ATTENDANCE(3),
    COR_ADD_ANNOUNCEMENT(4);

    private int id;

    AuthActions(int id){
        this.id = id;
    }

    public int getID(){ return id; }
}
