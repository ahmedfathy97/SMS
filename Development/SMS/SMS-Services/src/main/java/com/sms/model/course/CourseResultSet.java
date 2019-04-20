package com.sms.model.course;

import java.io.Serializable;
import java.util.List;

public class CourseResultSet implements Serializable {
    private List<CourseVTO> list;


    public CourseResultSet() {
    }

    public List<CourseVTO> getList() {
        return list;
    }

    public void setList(List<CourseVTO> list) {
        this.list = list;
    }
}
