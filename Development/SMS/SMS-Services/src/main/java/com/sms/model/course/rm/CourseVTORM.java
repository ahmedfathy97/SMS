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
        data.setName(rs.getString("cor_name"));
        return data;
    }
}
