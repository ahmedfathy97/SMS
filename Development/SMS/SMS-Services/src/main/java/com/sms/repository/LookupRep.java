package com.sms.repository;

import com.sms.model.CourseType;
import com.sms.model.CourseTypeRM;
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

    public List<CourseType> findCourseByInstID ( int instr_id){
        String sql="SELECT id,cor_name FROM course where instructor_id ="+instr_id+";";
        List<CourseType> list = this.jdbc.query(sql,new CourseTypeRM());
        return list;
    }
    public List<corCategory>findCorCategory (){
        String sql ="SELECT id,label_en FROM cor_category ";
        List<corCategory> list = this.jdbc.query(sql ,new corCategoeryVtoRM());
        return  list ;
    }
    public List<corType>findCorType (){
        String sql ="SELECT id,label_en FROM cor_type ";
        List<corType> list = this.jdbc.query(sql , new corCategoeryVtoRM());
        return  list;
    }
    public List<corLevel>findCorLevel (){
        String sql ="SELECT id,label_en FROM cor_level ";
        List<corLevel> list = this.jdbc.query(sql , new corLevelVtoRM());
       return list;
    }
}


