package com.sms.controller;

import com.sms.model.course.StdDTO;
import com.sms.repository.GradeRep;
import com.sms.service.GradeSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

//TODO: Hala - Path should be /grade
//TODO: Hala - Class should be GradeRes
@Path("/grade")
public class GradeRes {
    //TODO: Hala - variable name should be gradeService
    private GradeSer gradeService;
    //TODO: Hala - Class should be gradeRepository
    private GradeRep gradeRepository;

    @Autowired
    public GradeRes(GradeSer gradeService) {
        this.gradeService = gradeService;

    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //TODO: Hala - Path should be /{courseID}
    @Path("/{courseID}")
    //TODO: Hala - function should be createGradeSheet
    public void createGradeSheet(@PathParam("courseID") int courseID, List<StdDTO> students) {
        this.gradeService.createSheet(courseID, students);
        System.out.print("Data Recieved Sucessfully");
        System.out.print(students.toString());


    }


}
