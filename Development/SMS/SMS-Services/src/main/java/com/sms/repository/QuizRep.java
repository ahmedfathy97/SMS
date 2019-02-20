package com.sms.repository;

import com.sms.model.course.QuizDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuizRep {
    private JdbcTemplate jdbcTemplate ;
    @Autowired
    public QuizRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }








}
