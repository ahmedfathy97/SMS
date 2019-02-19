package com.sms.service;

import com.sms.model.course.StdDTO;
import com.sms.repository.GradeRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeSer {
    private GradeRep repository;

    @Autowired
    public GradeSer(GradeRep  repository) {
        this.repository = repository;

    }

    public void createSheet(int courseID, List<StdDTO> students) {
        for (StdDTO std : students)
            this.repository.insertStudentGrd(courseID, std);
        System.out.print("Data is inserted Sucessfully");
    }
}
