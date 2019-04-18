package com.sms.model.authorization;

public enum AuthRoles {
    INSTRUCTOR(1), STUDENT(2);

    private int id;

    AuthRoles(int id){
        this.id = id;
    }

    public int getID(){ return id; }

}
