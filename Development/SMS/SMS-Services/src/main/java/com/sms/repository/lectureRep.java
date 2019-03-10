package com.sms.repository;

import com.sms.model.course.LectureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class lectureRep {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public lectureRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertNewLecture(LectureDTO data){
        String sql =" INSERT INTO lecture(title , lecture_date , video_url , description)Values(?,?,?,?)";

        this.jdbcTemplate.update(sql, data.getTitle(), data.getDate(), data.getVideoUrl(), data.getDescription());

    }
}
