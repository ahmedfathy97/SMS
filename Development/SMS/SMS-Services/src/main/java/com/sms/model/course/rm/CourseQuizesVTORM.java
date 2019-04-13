package com.sms.model.course.rm;

import com.sms.model.course.CourseQuizesVTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseQuizesVTORM implements org.springframework.jdbc.core.RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowindex) throws SQLException {
        CourseQuizesVTO courseQuizesVTO = new CourseQuizesVTO() ;
        courseQuizesVTO.setQuizID(rs.getInt("id"));
        courseQuizesVTO.setQuizName(rs.getString("quiz_name"));
        return courseQuizesVTO ;
    }
}
