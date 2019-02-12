package com.sms.service;

import com.sms.data.StdDto;
import com.sms.repository.GradeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GradeSer {
    private GradeRep repository;
    @Autowired
    public GradeSer(GradeRep repository) {
        this.repository=repository;

    }
    public void insertStudentGrds(int courseID, List<StdDto> students){
        for(StdDto std: students)
            this.repository.insertStudentGrd(courseID, std);
        System.out.print("Data is inserted Sucessfully");
    }
}
