package com.sms.model.course;

import java.io.Serializable;
import java.util.List;

public class CourseResultSet implements Serializable {
    private List<CourseVTO> list;
    private List<Announcement> announclist;
    private List<LectureVTO> lectureList;
    private List<StdDTO> studentLis;
    private int totalRecords;
    private List<CourseVTO> listStudent;

    public List<CourseVTO> getListStudent() {
        return listStudent;
    }

    public void setListStudent(List<CourseVTO> listStudent) {
        this.listStudent = listStudent;
    }

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
        this.announclist = list;
    }

    public int getTotalRecords() {
        return totalRecords;
    }
    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
}
