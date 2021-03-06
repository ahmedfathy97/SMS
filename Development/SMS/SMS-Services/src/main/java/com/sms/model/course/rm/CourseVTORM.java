package com.sms.model.course.rm;

import com.sms.model.course.CourseVTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseVTORM implements RowMapper<CourseVTO> {

    @Override
    public CourseVTO mapRow(ResultSet rs, int rowIndex) throws SQLException {
        CourseVTO data=new CourseVTO();
        data.setId(rs.getInt("id"));
        data.setImagePath(rs.getString("image_path"));
        data.setCourseName(rs.getString("cor_name"));
        data.setDuration(rs.getInt("duration"));
        data.setStartDate(rs.getDate("start_date"));
        data.setEndDate(rs.getDate("end_date"));
        data.setDescription(rs.getString("description"));
        data.setInstructorName(rs.getString("first_name") + " " + rs.getString("last_name"));
        return data;
    }
}
