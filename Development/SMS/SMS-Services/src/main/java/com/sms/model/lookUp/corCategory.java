package com.sms.model.lookUp;

import java.io.Serializable;

//TODO: Youssef - rename Class to CorCategory - remember to change model in Angular too
public class corCategory implements Serializable {
    //TODO: Youssef - rename Variable to id
    private int ID ;
    //TODO: Youssef - rename Variable to labelEN
    private String labelEn ;

    public corCategory() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLabelEn() {
        return labelEn;
    }

    public void setLabelEn(String labelEn) {
        this.labelEn = labelEn;
    }
}
