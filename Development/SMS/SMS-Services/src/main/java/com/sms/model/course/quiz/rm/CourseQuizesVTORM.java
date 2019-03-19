package com.sms.model.course.quiz.rm;

import com.sms.model.course.quiz.CourseQuizesVTO;

import javax.swing.tree.RowMapper;
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
