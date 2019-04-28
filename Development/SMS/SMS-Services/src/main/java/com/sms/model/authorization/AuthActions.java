package com.sms.model.authorization;

public enum AuthActions {
    COR_ADD_GRADE(1);

    private int id;

    AuthActions(int id){
        this.id = id;
    }

    public int getID(){ return id; }
}
