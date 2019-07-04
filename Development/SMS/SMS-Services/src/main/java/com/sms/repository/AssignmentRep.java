package com.sms.repository;

import com.sms.model.AssignmentDTO;
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

    public void updateStdAssignments(int stdID, int fileToAssID, int fileAttachmentID) {
        String sql = "SELECT id FROM sms.course_assignment \n" +
                "where file_attach_id = ?;";

        System.err.println("FileID" + fileToAssID);

        int assignmentID = jdbcTemplate.queryForObject(sql, Integer.class, fileToAssID);
        System.err.println("assID" + assignmentID);

        sql = "UPDATE course_assign_answer SET file_attach_id = ? " +
                "WHERE std_id = ? AND assignment_id = ?";

        this.jdbcTemplate.update(sql, fileAttachmentID, stdID, assignmentID);

        sql = "UPDATE course_assign_answer SET answer_date = DATE(now()) " +
                "WHERE std_id = ? AND assignment_id = ?;";

        this.jdbcTemplate.update(sql, stdID, assignmentID);

    }

    public List<AssignmentDTO> getListOfAssignmentStudent(int corID, int lecID) {
        String sql = "SELECT std.user_id, std.first_name, std.last_name, answer.answer_date, answer.file_attach_id as std_answer_file, " +
                "assign.file_attach_id as assignment_file, DATEDIFF( assign.end_date, DATE(NOW())) as due_date" +
                "    From course_assign_answer answer" +
                "    LEFT JOIN course_assignment assign ON answer.assignment_id = assign.id" +
                "    LEFT JOIN user_detail std  ON answer.std_id = std.user_id" +
                "    LEFT JOIN attachment ans_file ON answer.file_attach_id = ans_file.file_id" +
                "    LEFT JOIN attachment assign_file ON assign_file.file_id = ans_file.file_id" +
                "    WHERE assign.cor_id = ? AND assign.lec_id = ?;";

        List<AssignmentDTO> assignments = this.jdbcTemplate.query(sql, new RowMapper<AssignmentDTO>() {
            @Override
            public AssignmentDTO mapRow(ResultSet rs, int i) throws SQLException {
                AssignmentDTO assignmentDTO = new AssignmentDTO();
                assignmentDTO.setStdID(rs.getInt("user_id"));
                assignmentDTO.setFirstName(rs.getString("first_name"));
                assignmentDTO.setLastName(rs.getString("last_name"));
                assignmentDTO.setAnswerDate(rs.getDate("answer_date"));
                assignmentDTO.setAnswerID(rs.getInt("std_answer_file"));
                assignmentDTO.setAssignID(rs.getInt("assignment_file"));
                assignmentDTO.setDueDate(rs.getInt("due_date"));

                System.out.println(assignmentDTO.toString());
                return assignmentDTO;
            }

        }, corID, lecID);
        return assignments;
    }
}
