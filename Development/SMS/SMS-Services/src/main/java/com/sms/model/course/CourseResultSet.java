package com.sms.model.course;

import java.io.Serializable;
import java.util.List;

public class CourseResultSet implements Serializable {
    private List<CourseVTO> list;
    private List<Announcement> announclist;
    private int totalRecords;


    public CourseResultSet() {
    }

    public List<CourseVTO> getList() {
        return list;
    }
    public void setList(List<CourseVTO> list) {
        this.list = list;
    }

    public List<Announcement> getAnnounclist() {
        return announclist;
    }
    public void setAnnounclist(List<Announcement> list) {
        this.announclist = announclist;
    }

    public int getTotalRecords() {
        return totalRecords;
    }
    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
}
