package com.sms.controller;

import com.sms.model.AssignmentDTO;
import com.sms.model.annotation.Authenticated;
import com.sms.model.authorization.AuthViews;
import com.sms.repository.AssignmentRep;
import com.sms.repository.AttachmentRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.text.Collator;
import java.util.Comparator;
import java.util.List;

@Path("/assignment")
public class AssignmentRes {

    private AssignmentRep AssRep;
    private AttachmentRep AttRep;

    @Autowired
    public AssignmentRes(AttachmentRep attRep, AssignmentRep assRep) {
        this.AttRep = attRep;
        this.AssRep = assRep;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
//    @Authenticated(views = {AuthViews.ADD_MATERIAL})

    public List<AssignmentDTO> listFiles(@QueryParam("corID") int corID,
                                         @QueryParam("lecID") int lecID) {
        List<AssignmentDTO> assignments = this.AssRep.getListOfAssignmentStudent(corID, lecID);
        java.util.Collections.sort(assignments, new Comparator<AssignmentDTO>() {
            @Override
            public int compare(AssignmentDTO ass1, AssignmentDTO ass2) {
                return ass1.getFirstName().compareTo(ass2.getFirstName());
            }
        });
        return assignments;
    }

}

