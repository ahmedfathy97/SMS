package com.sms.service;

import com.sms.data.StdDto;
import com.sms.model.AttendData;
import com.sms.repository.attendRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AttendSer {
    @Autowired
    attendRep repository;


    public AttendSer(attendRep repository) {
        this.repository = repository;
    }

    public void insertSheetDetails (int course_id , AttendData data) {

        int attendenceSheetID = this.repository.insertSheetDetails(course_id, data.getDate());
        for(StdDto student: data.getStdList())
            this.repository.insertAttendStd(attendenceSheetID, course_id, student);

    }

}
