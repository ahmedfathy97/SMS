package com.sms.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseTypeRM implements RowMapper<CourseType> {

    @Override
    public CourseType mapRow(ResultSet rs, int rowIndex) throws SQLException {
        CourseType data=new CourseType();
        data.setId(rs.getInt("id"));
        data.setLabelEN(rs.getString("cor_name"));
        return data;
    }
}
