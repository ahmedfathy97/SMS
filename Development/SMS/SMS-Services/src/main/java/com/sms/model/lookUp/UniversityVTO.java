package com.sms.model.lookUp;

public class UniversityVTO {
    private int id;
    private String labelEN;

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

    public UniversityVTO() {
    }

    public UniversityVTO(int id, String labelEN) {
        this.id = id;
        this.labelEN = labelEN;
    }

    @Override
    public String toString() {
        return "UniversityVTO{" +
                "id=" + id +
                ", labelEN='" + labelEN + '\'' +
                '}';
    }
}
