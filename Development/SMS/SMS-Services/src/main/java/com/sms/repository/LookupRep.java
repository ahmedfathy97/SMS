package com.sms.repository;

import com.sms.model.lookUp.CorCategory;
import com.sms.model.lookUp.CorLevel;
import com.sms.model.lookUp.CorType;
import com.sms.model.lookUp.rm.CorCategoryVTORM;
import com.sms.model.lookUp.rm.CorLevelVTORM;
import com.sms.model.lookUp.rm.CorTypeVTORM;
import com.sms.model.lookUp.QuestionType;
import com.sms.model.lookUp.rm.QuestionTypeRM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LookupRep {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public LookupRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<CorCategory> findCorCategory (){
        String sql ="SELECT id,label_en FROM cor_category ";
        return this.jdbcTemplate.query(sql ,new CorCategoryVTORM());
    }

    public List<CorType> findCorType (){
        String sql ="SELECT id,label_en FROM cor_type ";
        //TODO: Youssef - should use CorTypeVTORM
        return this.jdbcTemplate.query(sql , new CorTypeVTORM());
    }

    public List<CorLevel> findCorLevel (){
        String sql ="SELECT id,label_en FROM cor_level ";
        return this.jdbcTemplate.query(sql , new CorLevelVTORM());
    }

    public List<QuestionType> getAllQuestionType()
    {
        String sql ="SELECT * FROM question_type;" ;
        return this.jdbcTemplate.query(sql,new QuestionTypeRM()) ;
    }
}


