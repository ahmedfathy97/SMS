package com.sms.repository;

import com.sms.model.lookUp.corCategory;
import com.sms.model.lookUp.corLevel;
import com.sms.model.lookUp.corType;
import com.sms.model.lookUp.rm.corCategoeryVtoRM;
import com.sms.model.lookUp.rm.corLevelVtoRM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LookupRep {
    private JdbcTemplate jdbc;
    @Autowired
    public LookupRep(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    public List<corCategory> findCorCategory (){
        String sql ="SELECT id,label_en FROM cor_category ";
        return this.jdbc.query(sql ,new corCategoeryVtoRM());
    }

    public List<corType> findCorType (){
        String sql ="SELECT id,label_en FROM cor_type ";
        //TODO: Youssef - should use CorTypeVTORM
        return this.jdbc.query(sql , new corCategoeryVtoRM());
    }

    public List<corLevel> findCorLevel (){
        String sql ="SELECT id,label_en FROM cor_level ";
        return this.jdbc.query(sql , new corLevelVtoRM());
    }
}


