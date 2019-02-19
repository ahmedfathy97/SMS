package com.sms.service;


import com.sms.model.AttendanceDTO;
import com.sms.model.course.StdDTO;
import com.sms.repository.AttendanceRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceSer {
    private AttendanceRep repository;
    @Autowired
    public AttendanceSer(AttendanceRep repository) {
        this.repository = repository;
    }

    public void createSheet(int courseID , AttendanceDTO data) {
        int sheetID = this.repository.insertNewSheet(courseID, data.getAttendanceData());
        for(StdDTO student: data.getStudents())
            this.repository.insertStudentAttendance(sheetID, courseID, student);

    }

}
