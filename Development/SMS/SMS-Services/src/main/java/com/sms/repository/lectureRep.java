package com.sms.repository;

import com.sms.model.attachment.File;
import com.sms.model.course.LectureDTO;
import com.sms.model.course.LectureVTO;
import com.sms.model.course.quiz.rm.QuestionVTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class lectureRep {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public lectureRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertNewLecture( int courseID ,LectureDTO data){
        String sql =" INSERT INTO lecture(title , lecture_date , video_url , description)Values(?,?,?,?)";

        this.jdbcTemplate.update(sql, data.getTitle(), data.getDate(), data.getVideoUrl(), data.getDescription());
    }

    public LectureDTO getLecture(int lecID){
        String sql = "SELECT title,video_url,description FROM lecture WHERE id=?";

        LectureDTO lecture = this.jdbcTemplate.queryForObject(sql, new RowMapper<LectureDTO>() {
            @Override
            public LectureDTO mapRow(ResultSet rs, int i) throws SQLException {
                LectureDTO lecture = new LectureDTO();
                lecture.setTitle(rs.getString("title"));
                lecture.setVideoUrl(rs.getString("video_url"));
//                lecture.setDate(rs.getDate("lecture_date"));
                lecture.setDescription(rs.getString("description"));

                return lecture;
            }
        }, lecID);

        return lecture;
    }
}
