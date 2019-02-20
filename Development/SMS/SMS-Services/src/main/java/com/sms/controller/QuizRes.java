package com.sms.controller;

import com.sms.model.course.QuizDTO;
import com.sms.service.QuizSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

public class QuizRes {
    private QuizSer quizSer ;
    @Autowired
    public QuizRes(QuizSer quizSer) {
        this.quizSer=quizSer ;
    }


}
