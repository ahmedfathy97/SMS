package com.sms.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AssignmentRep {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AssignmentRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public List<Assignment> findFiles(int corID, int sourceID ,int file_src_id) {
//        String sql = "SELECT file_id, first_name, last_name, state, upload_date, start_date, end_date " +
//                "FROM attachment " +
//                "WHERE corID = ? AND source_id = ? AND file_src_id = ?  ";
//
//        List<Assignment> files = this.jdbcTemplate.query(sql, new FileRm(),corID, sourceID, file_src_id);
//        return files;
//    }

}
