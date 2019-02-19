package com.sms.repository;


import com.sms.model.course.StdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AttendanceRep {

    private JdbcTemplate jdbc ;
    private SimpleJdbcInsert attendanceSJI;

    @Autowired
    public AttendanceRep(JdbcTemplate jdbc, DataSource dataSource) {
        attendanceSJI = new SimpleJdbcInsert(dataSource).withTableName("attendance").usingGeneratedKeyColumns("id");
        this.jdbc = jdbc;
    }

    public int insertNewSheet(int courseID , Date sheetDate){
        Map<String, Object> parameters = new HashMap<>(2);
        parameters.put("cor_id", courseID);
        parameters.put("created_on", "2018-05-12");
        Number newId = attendanceSJI.executeAndReturnKey(parameters);
        return newId.intValue();
    }

    public void insertStudentAttendance(int attendanceSheetID, int courseID , StdDTO data){
        String sql = "INSERT INTO cor_std_att ( att_id , cor_id , std_id , is_attended ) value (?,?,?,?)";
        this.jdbc.update(sql , attendanceSheetID, courseID , data.getId() ,data.getIsAttend() ? "1" : "0"); }

}
