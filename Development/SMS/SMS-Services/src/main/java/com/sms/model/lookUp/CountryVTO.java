package com.sms.model.lookUp;

public class CountryVTO {
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

    public CountryVTO() {
    }

    public CountryVTO(int id, String labelEN) {
        this.id = id;
        this.labelEN = labelEN;
    }
    @Override
    public String toString() {
        return "CountryVTO{" +
                "id=" + id +
                ", labelEN='" + labelEN + '\'' +
                '}';
    }
}
