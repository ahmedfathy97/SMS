package com.sms.model.lookUp;

import java.io.Serializable;

public class corCategory implements Serializable {
    private int ID ;
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
