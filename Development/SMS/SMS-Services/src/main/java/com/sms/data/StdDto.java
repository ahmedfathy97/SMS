package com.sms.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StdDto  implements Serializable {
    private  int id;
    private String fullName;

//    List<StdDto> list=new ArrayList<>();
//    list.add(id);
//    list.add(fullName);

    public StdDto() {
    }

//    public List<StdDto> getList() {
//        return list;
//    }
//
//    public void setList(List<StdDto> list) {
//        this.list = list;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "StdDto{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
