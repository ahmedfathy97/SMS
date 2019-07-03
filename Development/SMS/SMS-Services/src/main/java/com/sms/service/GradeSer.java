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

    public void createSheet(int courseID, List<StdDTO> students ,String gradeType) {
        if (gradeType.equals("M"))
            for (StdDTO std : students)
                this.repository.insertMidTerm(courseID, std);
//        else if (gradeType.equals("M2"))
//            for (StdDTO std : students)
//                this.repository.insertMidTermTwo(courseID, std);
//        else if (gradeType.equals("SF"))
//            for (StdDTO std : students)
//                this.repository.insertSemiFinal(courseID, std);
        else if (gradeType.equals("F"))
            for (StdDTO std : students)
                this.repository.insertFinalGrd(courseID, std);
        System.out.print("Data is inserted Sucessfully");
    }

    public List<StdDTO> getQuizGrade(int courseID){
        List<StdDTO> quiz= repository.findQuizGrades(courseID);
        return quiz;

    }
}
