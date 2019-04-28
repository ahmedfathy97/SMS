package com.sms.controller;

import com.sms.model.annotation.Authenticated;
import com.sms.model.authorization.AuthActions;
import com.sms.model.course.StdDTO;
import com.sms.repository.GradeRep;
import com.sms.service.GradeSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/grade/")
public class GradeRes {
    private GradeSer gradeService;
    private GradeRep gradeRepository;

    @Autowired
    public GradeRes(GradeSer gradeService) {
        this.gradeService = gradeService;

    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/new")
    @Authenticated(actions = {AuthActions.COR_ADD_GRADE})
    public void createGradeSheet(@PathParam("courseID") int courseID, List<StdDTO> students,
                                 @QueryParam("gradeType") String gradeType) {
        this.gradeService.createSheet(courseID, students, gradeType);
        System.out.print("Data Recieved Sucessfully");
        System.out.print(students.toString());


    }


}
