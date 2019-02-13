package com.sms.repository;

import com.sms.data.StdDto;
import com.sms.model.AttendData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
//TODO: Yara - Rename to AttendanceRep
public class attendRep {

    private JdbcTemplate jdbc ;
    //TODO: Yara - should be private and rename to attendanceSJI
    SimpleJdbcInsert simpleJdbcInsert;
    @Autowired
    public attendRep(JdbcTemplate jdbc, DataSource dataSource) {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("attendance").usingGeneratedKeyColumns("id");
        this.jdbc = jdbc;
    }

    //TODO: Yara - Rename to insertNewSheet
    public int insertSheetDetails (int courseID , Date sheetDate){
        Map<String, Object> parameters = new HashMap<>(2);
        parameters.put("cor_id", courseID);
        parameters.put("attendance_date", "2018-05-12");
        Number newId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return newId.intValue();
    }

    //TODO: Yara - Rename to insertStudentAttendance
    public void insertAttendStd (int attendanceSheetID, int courseID , StdDto data){
        String sql = "INSERT INTO cor_std_att ( att_id , cor_id , std_id , attend ) value (?,?,?,?)";
        this.jdbc.update(sql , attendanceSheetID, courseID , data.getId() ,data.getIsAttend() ? "1" : "0"); }

}
