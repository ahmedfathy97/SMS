package com.sms.controller;

import com.sms.model.lookUp.QuestionType;
import com.sms.model.lookUp.corCategory;
import com.sms.model.lookUp.corLevel;
import com.sms.model.lookUp.corType;
import com.sms.repository.LookupRep;
import com.sms.service.LookUpSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/lookup")
public class LookupRes {
    private LookupRep repositry;
    private LookUpSer lookUpSer ;

    @Autowired
    public LookupRes(LookupRep repositry ,LookUpSer lookUpSer) {
        this.repositry = repositry;
        this.lookUpSer =lookUpSer ;
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/corCategory")
    public List<corCategory> findCorCategory() {
        List<corCategory> list =this.repositry.findCorCategory();
        return list;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/corType")
    public List<corType> findCorType() {
        List<corType> list =this.repositry.findCorType();
        return list;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/corLevel")
    public List<corLevel> findCorLevel() {
        List<corLevel> list =this.repositry.findCorLevel();
        return list;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/questionType")
    public List<QuestionType> getallquestionsType() {
        List<QuestionType> questionTypeList =this.lookUpSer.getAllQuestionsTypes() ;
        return questionTypeList;
    }

}
