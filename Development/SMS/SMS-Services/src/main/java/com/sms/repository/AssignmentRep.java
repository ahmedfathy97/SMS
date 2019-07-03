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

@Repository
public class AssignmentRep {
    private JdbcTemplate jdbcTemplate;
    private CourseRep courseRep;

    @Autowired
    public AssignmentRep(JdbcTemplate jdbcTemplate, CourseRep courseRep) {
        this.jdbcTemplate = jdbcTemplate;
        this.courseRep = courseRep;
    }

    public int insertIntoCourse_assignment(int attachmentID) {
        String sql = "INSERT INTO course_assignment (cor_id, lec_id, file_attach_id, start_date, end_date)" +
                "            SELECT cor_id, source_id, file_id, start_date, end_date" +
                "            FROM attachment" +
                "            WHERE file_src_id = 2 AND file_id = ?;";
        this.jdbcTemplate.update(sql, attachmentID);

        sql = "SELECT id FROM course_assignment ORDER BY id DESC LIMIT 1;";
        int assignmentID = jdbcTemplate.queryForObject(sql, Integer.class);


        return assignmentID;
    }

    public void insertStdAssignments(int corID, int assignmentID) {
        List<StdDTO> stdDTOS = this.courseRep.findAllCourseStudents(corID, -1);
        String sql = "INSERT INTO course_assign_answer (std_id, assignment_id) VALUE (?, ?)";

        for(StdDTO std : stdDTOS){
            this.jdbcTemplate.update(sql, std.getId(), assignmentID);
        }
    }

    public void updateStdAssignments(int stdID, int assignmentID, int fileAttachmentID) {
        String sql = "UPDATE course_assign_answer SET answer_date = NOW() " +
                "WHERE std_id = ? AND assignment_id = ?;";

        this.jdbcTemplate.update(sql, stdID, assignmentID);

        sql = "UPDATE course_assign_answer SET file_attach_id = ? " +
                "WHERE std_id = ? AND assignment_id = ?;";

        this.jdbcTemplate.update(sql, fileAttachmentID, stdID, assignmentID);
    }
}
