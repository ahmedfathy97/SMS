package com.sms.model.lookUp;

import java.io.Serializable;

//TODO: Youssef - rename Class to CorType - remember to change model in Angular too
public class CorType implements Serializable {
    //TODO: Youssef - rename Variable to id
    private int id;
    //TODO: Youssef - rename Variable to labelEN
    private String labelEN;

    public CorType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabelEN() {
        return labelEN;
    }

    public void setLabelEN(String labelEN) {
        this.labelEN = labelEN;
    }
}
