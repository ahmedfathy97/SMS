package com.sms.controller;

import com.sms.model.lookUp.QuestionType;
import com.sms.model.lookUp.CorCategory;
import com.sms.model.lookUp.CorLevel;
import com.sms.model.lookUp.CorType;
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
    private LookupRep repository;
    private LookUpSer lookUpSer;

    @Autowired
    public LookupRes(LookupRep repository) {
        this.repository = repository;
    }
    public LookupRes(LookupRep repository, LookUpSer lookUpSer) {
            this.repository = repository;
            this.lookUpSer = lookUpSer;
        }


        @GET
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/corCategoryList")
        public List<CorCategory> findCorCategory () {
            List<CorCategory> list = this.repository.findCorCategory();
            return list;
        }

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/corTypeList")
        public List<CorType> findCorType () {
            List<CorType> list = this.repository.findCorType();
            return list;
        }

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/corLevelList")
        public List<CorLevel> findCorLevel () {
            List<CorLevel> list = this.repository.findCorLevel();
            return list;
        }


        @GET
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/questionType")
        public List<QuestionType> getallquestionsType () {
            List<QuestionType> questionTypeList = this.lookUpSer.getAllQuestionsTypes();
            return questionTypeList;
        }

    }

