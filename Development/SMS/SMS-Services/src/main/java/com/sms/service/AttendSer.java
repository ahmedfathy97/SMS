package com.sms.service;

import com.sms.data.StdDto;
import com.sms.model.AttendData;
import com.sms.repository.attendRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//TODO: Yara - rename Class to AttendanceSer
public class AttendSer {
    //TODO: Yara - use Constructor Injection and variable should be private
    @Autowired
    attendRep repository;

    public AttendSer(attendRep repository) {
        this.repository = repository;
    }

    //TODO: Yara - rename function to createSheet
    //TODO: Yara - rename course_id to courseID
    public void insertSheetDetails (int course_id , AttendData data) {

        int sheetID = this.repository.insertSheetDetails(course_id, data.getDate());
        for(StdDto student: data.getStdList())
            this.repository.insertAttendStd(sheetID, course_id, student);

    }

}
