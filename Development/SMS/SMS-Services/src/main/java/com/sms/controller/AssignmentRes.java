package com.sms.controller;

import com.sms.model.annotation.Authenticated;
import com.sms.model.authorization.AuthViews;
import com.sms.repository.AttachmentRep;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

//@Path("/assignment")
public class AssignmentRes {

//    private AssignmentRep AssRep;
//    private AttachmentRep AttRep;
//
//    public AssignmentRes(AttachmentRep attRep, AssignmentRep AssRep){
//        this.AttRep = attRep;
//        this.AssRep = assRep;
//    }
//    public AssignmentRes(){}
//
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/files")
//    @Authenticated(views = {AuthViews.LECTURE_DETAILS})
//
//    public List<Assignment> listFiles(@QueryParam("corID") int corID,
//                                @QueryParam("sourceID") int sourceID,
//                                @QueryParam("fileSrcID") int fileSrcID)
//    {
//        List<Assignment> assignments = this.AssRep.findFiles(corID ,sourceID ,fileSrcID);
////        System.out.println(files.get(0).toString());
//        return assignment;
//
//    }

}

