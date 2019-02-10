package com.sms.repository;

import com.sms.model.CourseType;
import com.sms.model.CourseTypeRM;
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
}


