package com.sms.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRep {
    private JdbcTemplate jdbc;
    @Autowired

    public StudentRep(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    public void insertStudent(int courseID,  int studentid){
        String sql="INSERT INTO course_std" +
                "(cor_id,std_id)" +
                "VALUES(?,?)";
        this.jdbc.update(sql,courseID,studentid);

    }
}
