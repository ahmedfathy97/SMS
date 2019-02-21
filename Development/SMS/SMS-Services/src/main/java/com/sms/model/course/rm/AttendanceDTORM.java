package com.sms.model.course.rm;

import com.sms.model.course.StdDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//TODO: Yara - rename Class to CourseVTORM
//TODO: Yara - move Class to /model/course/rm

public class AttendanceDTORM implements RowMapper<StdDTO> {


    @Override
    public StdDTO mapRow(ResultSet rs, int rowIndex) throws SQLException {

        StdDTO data=new StdDTO();
        String firstName=rs.getString("first_name");
        String lastName=rs.getString("last_name");
        data.setFullName(firstName + " " +lastName);
        data.setAttendanceDate(rs.getDate("created_on"));
        data.setIsAttend(rs.getBoolean("is_attended"));
        return data;
    }
}
