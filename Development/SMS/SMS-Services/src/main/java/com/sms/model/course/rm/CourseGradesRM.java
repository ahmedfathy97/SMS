package com.sms.model.course.rm;

import com.sms.model.course.StdDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseGradesRM implements RowMapper<StdDTO> {
    @Override
    public StdDTO mapRow(ResultSet rs, int rowIndex) throws SQLException {
        StdDTO data=new StdDTO();
        String firstName=rs.getString("first_name");
        String lastName=rs.getString("last_name");

        data.setFullName(firstName + " " +lastName);
        data.setId(rs.getInt("user_id"));
        data.setMidTermOne(rs.getInt("mid_1_grd"));
        data.setSemiFinal(rs.getInt("semi_final_grd"));
        data.setMidTermTwo(rs.getInt("mid_2_grd"));
        data.setFinalGrd(rs.getInt("final_grd"));
        return data;
    }
}
