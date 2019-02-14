package com.sms.service;

import com.sms.data.StdDto;
import com.sms.model.AttendanceDTO;
import com.sms.repository.AttendanceRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//TODO: Yara - rename Class to AttendanceSer
public class AttendanceSer {
    //TODO: Yara - use Constructor Injection and variable should be private

    private AttendanceRep repository;
    @Autowired
    public AttendanceSer(AttendanceRep repository) {
        this.repository = repository;
    }

    //TODO: Yara - rename function to createSheet
    //TODO: Yara - rename course_id to courseID
    public void createSheet(int courseID , AttendanceDTO data) {

        int sheetID = this.repository.insertNewSheet(courseID, data.getDate());
        for(StdDto student: data.getStudents())
            this.repository.insertStudentAttendance(sheetID, courseID, student);

    }

}
