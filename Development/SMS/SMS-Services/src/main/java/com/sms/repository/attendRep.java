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
public class attendRep {

    private JdbcTemplate jdbc ;
    SimpleJdbcInsert simpleJdbcInsert;
    @Autowired
    public attendRep(JdbcTemplate jdbc, DataSource dataSource) {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("attendance").usingGeneratedKeyColumns("id");
        this.jdbc = jdbc;
    }



    public int insertSheetDetails (int courseID , Date sheetDate){
        Map<String, Object> parameters = new HashMap<>(2);
        parameters.put("cor_id", courseID);
        parameters.put("attendance_date", "2018-05-12");
        Number newId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return newId.intValue();
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        String sql = "INSERT INTO attendance ( cor_id , attendance_date ) " +
//                "value (?,?)";
//        jdbc.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, courseID);
//            ps.setString(2, "2018-05-12");
//            return ps;
//        }, keyHolder);
//
//        return (int) keyHolder.getKey();
    }

    public void insertAttendStd (int attendenceSheetID, int courseID , StdDto data){
        String sql = "INSERT INTO cor_std_att ( att_id , cor_id , std_id , attend ) " +
                "value (?,?,?,?)";
        this.jdbc.update(sql , attendenceSheetID, courseID , data.getId() ,data.getIsAttend() ? "1" : "0"); }

}
