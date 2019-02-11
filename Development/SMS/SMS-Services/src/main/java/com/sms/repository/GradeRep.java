package com.sms.repository;

import com.sms.data.CourseGrd;
import com.sms.data.StdDto;
import com.sms.data.StdDtoRM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class GradeRep {
    private JdbcTemplate jdbc;
    @Autowired

    public GradeRep(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    public List<StdDto>findStdByCorID(int corId){
        String sql="SELECT first_name,last_name,std.id   FROM course_std " +
                "LEFT JOIN auth_user std" +
                " on std.id = course_std.std_id " +
                "where cor_id=? ";
        List<StdDto> list = this.jdbc.query(sql,new StdDtoRM(),corId);



        return  list;

    }
}
