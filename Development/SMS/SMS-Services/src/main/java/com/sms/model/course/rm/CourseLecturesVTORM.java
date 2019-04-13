package com.sms.model.course.rm;

import com.sms.model.course.CourseLecturesVTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseLecturesVTORM implements org.springframework.jdbc.core.RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowindex) throws SQLException {
        CourseLecturesVTO courseLecturesVTO = new CourseLecturesVTO() ;
        courseLecturesVTO.setLectureID(rs.getInt("id"));
        courseLecturesVTO.setLectureTitle(rs.getString("title"));
        return courseLecturesVTO ;
    }
}
