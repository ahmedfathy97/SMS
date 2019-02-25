package com.sms.model.course.rm;

import com.sms.model.course.CourseVTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseViewVTORM implements RowMapper<CourseVTO> {

    @Override
    public CourseVTO mapRow(ResultSet rs, int rowIndex) throws SQLException {
        CourseVTO data=new CourseVTO();
        data.setCourseName(rs.getString("cor_name"));
        data.setDuration(rs.getInt("duration"));
        data.setStartDate(rs.getDate("start_date"));
        data.setEndDate(rs.getDate("end_date"));
        data.setCorCategory(rs.getString("cor_category"));
        data.setCorType(rs.getString("cor_type"));
        data.setCorLevel(rs.getString("cor_level"));
        data.setStudentNum(rs.getInt("course_std"));
        data.setInstructorName(rs.getString("Instructor_Name"));
        data.setDescription(rs.getString("description"));
        return data;
    }
}
