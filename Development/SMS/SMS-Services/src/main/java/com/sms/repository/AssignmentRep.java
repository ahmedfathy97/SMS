package com.sms.repository;

import com.sms.model.attachment.File;
import com.sms.model.course.StdDTO;
import com.sms.model.course.rm.StdDTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AssignmentRep {
    private JdbcTemplate jdbcTemplate;
    private CourseRep courseRep;

    @Autowired
    public AssignmentRep(JdbcTemplate jdbcTemplate, CourseRep courseRep) {
        this.jdbcTemplate = jdbcTemplate;
        this.courseRep = courseRep;
    }

//    public List<Assignment> findFiles(int corID, int sourceID ,int file_src_id) {
public void insertIntoCourse_assignment() {
    String sql = "INSERT INTO course_assignment (cor_id, lec_id, file_attach_id, start_date, end_date)" +
            "            SELECT cor_id, source_id, file_id, start_date, end_date" +
            "            FROM attachment" +
            "            WHERE file_src_id = 2;";

    this.jdbcTemplate.update(sql);


}

    public void insertIntoCourse_assignment_answer(int cor_id) {
        List<StdDTO> stdDTOS = this.courseRep.findAllCourseStudents(cor_id, -1);

        String sql = "INSERT INTO course_assignment_answer (std_id, assignment_id)" +
                "            SELECT cor_id, source_id, file_id, start_date, end_date" +
                "            FROM attachment" +
                "            WHERE file_src_id = 2;";

        this.jdbcTemplate.update(sql);

    }

}
