package com.sms.model.course.rm;

import com.sms.model.course.LectureVTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseLecturesVTORM implements org.springframework.jdbc.core.RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowindex) throws SQLException {
        LectureVTO lectureVTO = new LectureVTO() ;
        lectureVTO.setLectureID(rs.getInt("id"));
        lectureVTO.setLectureTitle(rs.getString("title"));
        lectureVTO.setLectureDate(rs.getDate("lecture_date"));
        return lectureVTO;
    }
}
