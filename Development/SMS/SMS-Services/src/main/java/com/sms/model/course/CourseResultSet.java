package com.sms.model.course;

import java.io.Serializable;
import java.util.List;

public class CourseResultSet implements Serializable {
    private List<CourseVTO> list;
    private List<Announcement> announclist;
    private List<LectureVTO> lectureList;
    private List<StdDTO> studentLis;
    private int totalRecords;

    public List<StdDTO> getStudentLis() {
        return studentLis;
    }

    public void setStudentLis(List<StdDTO> studentLis) {
        this.studentLis = studentLis;
    }

    public CourseResultSet() {
    }

    public List<LectureVTO> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<LectureVTO> lectureList) {
        this.lectureList = lectureList;
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
