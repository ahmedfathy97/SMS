package com.sms.model.authorization;

public enum AuthViews {
    USER_LIST(1);
    private int id;

    AuthViews(int id){
        this.id = id;
    }

    public int getID(){ return id; }
}
