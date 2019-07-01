package com.sms.repository;

import com.sms.model.course.StdDTO;
import com.sms.model.course.rm.CourseGradesRM;
import com.sms.model.course.rm.QuizVTORM;
import com.sms.model.course.rm.StdDTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository

public class GradeRep {
    private JdbcTemplate jdbc;

    @Autowired

    public GradeRep(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    public void insertMidTermOne(int cor_id, StdDTO data) {
        String sql = "update course_std " +
                " SET  mid_1_grd=?  " +
                "WHERE   cor_id=? AND  std_id = ? ";
        this.jdbc.update(sql, data.getNewGrade(), cor_id, data.getId());

    }

    public void insertSemiFinal(int cor_id, StdDTO data) {
        String sql = "update course_std " +
                " SET  semi_final_grd=?  " +
                "WHERE   cor_id=? AND  std_id = ? ";
        this.jdbc.update(sql, data.getNewGrade(), cor_id, data.getId());

    }

    public void insertMidTermTwo(int cor_id, StdDTO data) {
        String sql = "update course_std " +
                " SET  mid_2_grd=?  " +
                "WHERE   cor_id=? AND  std_id = ? ";
        this.jdbc.update(sql, data.getNewGrade(), cor_id, data.getId());

    }

    public void insertFinalGrd(int cor_id, StdDTO data) {
        String sql = "update course_std " +
                " SET  final_grd=?  " +
                "WHERE   cor_id=? AND  std_id = ? ";
        this.jdbc.update(sql, data.getNewGrade(), cor_id, data.getId());

    }

    public List<StdDTO> findCourseGrades(int courseID, int stdID, int pageNum) {
        int pageSize = 2;

        String sql =
            "SELECT std.first_name,std.last_name,std.user_id, " +
                "cor.mid_grade,cor.final_grade " +
            " from user_detail std " +
                " left join course_std cor on std.user_id=cor.std_id\n" +
            " where cor_id = ? "
                    + ((stdID != -1 ) ? "AND cor.std_id = ?" : "") +
            " LIMIT " + pageSize + " OFFSET " + (pageSize * (pageNum-1));

        return ((stdID != -1 ) ? this.jdbc.query(sql, new CourseGradesRM(), courseID, stdID) :
                this.jdbc.query(sql, new CourseGradesRM(), courseID));
    }
    public int findALLGradeCount(int corID,int stdID){
        int pageSize = 2;
        String sql ="SELECT COUNT(*) AS record_count \n" +
                "                FROM user_detail std\n" +
                "                left join course_std cor\n" +
                "                on std.user_id=cor.std_id\n" +
                "                where cor_id = ?" +
                ((stdID != -1 ) ? "AND cor.std_id = ?"  :"") ;


        List<Integer> totalCount = this.jdbc.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt("record_count");
            }
        },corID);
        return totalCount.get(0);

    }

    public StdDTO findStudentGrades(int courseID, int stdID) {
        String sql = "SELECT std.first_name,std.last_name,std.user_id,\n" +
                "                cor.mid_1_grd,cor.semi_final_grd,cor.mid_2_grd,cor.final_grd\n" +
                "                from user_detail std\n" +
                "                   left join course_std cor\n" +
                "                on std.user_id=cor.std_id\n" +
                "where cor_id=?" +
                "                And std.user_id=?\n";


        StdDTO std = this.jdbc.queryForObject(sql, new CourseGradesRM(), courseID, stdID);

        return std;
    }
    public List<StdDTO> findQuizGrades(int courseID){
        String sql="\n" +
                "SELECT distinct\n" +
                "    q0.first_name,\n" +
                "    q0.last_name,\n" +
                "    q1.std_grade AS q1_std_grade,\n" +
                "    q1.quiz_grade AS q1_quiz_grade,\n" +
                "    q2.std_grade AS q2_std_grade,\n" +
                "    q2.quiz_grade AS q2_quiz_grade,\n" +
                "    q3.std_grade AS q3_std_grade,\n" +
                "    q3.quiz_grade AS q3_quiz_grade,\n" +
                "    q4.std_grade AS q4_std_grade,\n" +
                "    q4.quiz_grade AS q4_quiz_grade,\n" +
                "    q5.std_grade AS q5_std_grade,\n" +
                "    q5.quiz_grade AS q5_quiz_grade,\n" +
                "     q6.std_grade AS q6_std_grade,\n" +
                "    q6.quiz_grade AS q6_quiz_grade,\n" +
                "    q7.std_grade AS q7_std_grade,\n" +
                "    q7.quiz_grade AS q7_quiz_grade,\n" +
                "    q8.std_grade AS q8_std_grade,\n" +
                "    q8.quiz_grade AS q8_quiz_grade,\n" +
                "    q9.std_grade AS q9_std_grade,\n" +
                "    q9.quiz_grade AS q9_quiz_grade,\n" +
                "    q10.std_grade AS q10_std_grade,\n" +
                "    q10.quiz_grade AS q10_quiz_grade\n" +
                "FROM \n" +
                "    (SELECT s.user_id, std.first_name, std.last_name, s.quiz_id, q.quiz_name, ifnull(SUM(s.student_score), 0) AS total_mark, q.grade\n" +
                "\t\tFROM course_std cor_std \n" +
                "\t\t\tLEFT JOIN user_detail std ON std.user_id = cor_std.std_id\n" +
                "\t\t\tLEFT JOIN student_answer s ON cor_std.std_id = s.user_id\n" +
                "\t\t\tLEFT JOIN quiz q ON s.quiz_id = q.id\n" +
                "\t\tWHERE cor_std.cor_id = ? GROUP BY cor_std.std_id,s.quiz_id) q0\n" +
                "LEFT JOIN\n" +
                "    (SELECT  s.user_id,\n" +
                "            s.quiz_id,\n" +
                "            q.quiz_name,\n" +
                "            ifnull(SUM(s.student_score), 0) AS std_grade,\n" +
                "            q.grade AS quiz_grade\n" +
                "    FROM\n" +
                "    course_std cor_std \n" +
                "    LEFT JOIN student_answer s ON cor_std.std_id = s.user_id\n" +
                "    LEFT JOIN quiz q ON s.quiz_id = q.id\n" +
                "    WHERE\n" +
                "        cor_std.cor_id = ?\n" +
                "    GROUP BY cor_std.std_id,s.quiz_id) q1 ON q0.user_id = q1.user_id\n" +
                "        AND q1.quiz_name = 'quiz1'\n" +
                "        LEFT JOIN\n" +
                "    (SELECT \n" +
                "        s.user_id,\n" +
                "            s.quiz_id,\n" +
                "            q.quiz_name,\n" +
                "            ifnull(SUM(s.student_score), 0) AS std_grade,\n" +
                "            q.grade AS quiz_grade\n" +
                "    FROM\n" +
                "    course_std cor_std \n" +
                "    LEFT JOIN student_answer s ON cor_std.std_id = s.user_id\n" +
                "    LEFT JOIN quiz q ON s.quiz_id = q.id\n" +
                "    WHERE\n" +
                "        cor_std.cor_id = ?\n" +
                "    GROUP BY cor_std.std_id,s.quiz_id) q2 ON q0.user_id = q2.user_id\n" +
                "        AND q2.quiz_name = 'quiz2'\n" +
                "        LEFT JOIN\n" +
                "    (SELECT \n" +
                "        s.user_id,\n" +
                "            s.quiz_id,\n" +
                "            q.quiz_name,\n" +
                "            ifnull(SUM(s.student_score), 0) AS std_grade,\n" +
                "            q.grade AS quiz_grade\n" +
                "    FROM\n" +
                "    course_std cor_std \n" +
                "    LEFT JOIN student_answer s ON cor_std.std_id = s.user_id\n" +
                "    LEFT JOIN quiz q ON s.quiz_id = q.id\n" +
                "    WHERE\n" +
                "        cor_std.cor_id = ?\n" +
                "    GROUP BY cor_std.std_id,s.quiz_id) q3 ON q0.user_id = q3.user_id\n" +
                "        AND q3.quiz_name = 'quiz3'\n" +
                "          LEFT JOIN\n" +
                "    (SELECT \n" +
                "        s.user_id,\n" +
                "            s.quiz_id,\n" +
                "            q.quiz_name,\n" +
                "            ifnull(SUM(s.student_score), 0) AS std_grade,\n" +
                "            q.grade AS quiz_grade\n" +
                "    FROM\n" +
                "    course_std cor_std \n" +
                "    LEFT JOIN student_answer s ON cor_std.std_id = s.user_id\n" +
                "    LEFT JOIN quiz q ON s.quiz_id = q.id\n" +
                "    WHERE\n" +
                "        cor_std.cor_id = ?\n" +
                "    GROUP BY cor_std.std_id,s.quiz_id) q4 ON q0.user_id = q4.user_id\n" +
                "        AND q4.quiz_name = 'quiz4'\n" +
                "        LEFT JOIN\n" +
                "    (SELECT \n" +
                "        s.user_id,\n" +
                "            s.quiz_id,\n" +
                "            q.quiz_name,\n" +
                "            ifnull(SUM(s.student_score), 0) AS std_grade,\n" +
                "            q.grade AS quiz_grade\n" +
                "    FROM\n" +
                "    course_std cor_std \n" +
                "    LEFT JOIN student_answer s ON cor_std.std_id = s.user_id\n" +
                "    LEFT JOIN quiz q ON s.quiz_id = q.id\n" +
                "    WHERE\n" +
                "        cor_std.cor_id = ?\n" +
                "    GROUP BY cor_std.std_id,s.quiz_id) q5 ON q0.user_id = q5.user_id\n" +
                "        AND q5.quiz_name = 'quiz5'\n" +
                "        LEFT JOIN\n" +
                "    (SELECT \n" +
                "        s.user_id,\n" +
                "            s.quiz_id,\n" +
                "            q.quiz_name,\n" +
                "            ifnull(SUM(s.student_score), 0) AS std_grade,\n" +
                "            q.grade AS quiz_grade\n" +
                "    FROM\n" +
                "    course_std cor_std \n" +
                "    LEFT JOIN student_answer s ON cor_std.std_id = s.user_id\n" +
                "    LEFT JOIN quiz q ON s.quiz_id = q.id\n" +
                "    WHERE\n" +
                "        cor_std.cor_id = ?\n" +
                "    GROUP BY cor_std.std_id,s.quiz_id) q6 ON q0.user_id = q6.user_id\n" +
                "        AND q6.quiz_name = 'quiz6'\n" +
                "\tLEFT JOIN\n" +
                "    (SELECT \n" +
                "        s.user_id,\n" +
                "            s.quiz_id,\n" +
                "            q.quiz_name,\n" +
                "            ifnull(SUM(s.student_score), 0) AS std_grade,\n" +
                "            q.grade AS quiz_grade\n" +
                "    FROM\n" +
                "    course_std cor_std \n" +
                "    LEFT JOIN student_answer s ON cor_std.std_id = s.user_id\n" +
                "    LEFT JOIN quiz q ON s.quiz_id = q.id\n" +
                "    WHERE\n" +
                "        cor_std.cor_id = ?\n" +
                "    GROUP BY cor_std.std_id,s.quiz_id) q7 ON q0.user_id = q7.user_id\n" +
                "        AND q7.quiz_name = 'quiz7'\n" +
                "        LEFT JOIN\n" +
                "    (SELECT \n" +
                "        s.user_id,\n" +
                "            s.quiz_id,\n" +
                "            q.quiz_name,\n" +
                "            ifnull(SUM(s.student_score), 0) AS std_grade,\n" +
                "            q.grade AS quiz_grade\n" +
                "    FROM\n" +
                "    course_std cor_std \n" +
                "    LEFT JOIN student_answer s ON cor_std.std_id = s.user_id\n" +
                "    LEFT JOIN quiz q ON s.quiz_id = q.id\n" +
                "    WHERE\n" +
                "        cor_std.cor_id = ?\n" +
                "    GROUP BY cor_std.std_id,s.quiz_id) q8 ON q0.user_id = q8.user_id\n" +
                "        AND q8.quiz_name = 'quiz8'\n" +
                "        LEFT JOIN\n" +
                "    (SELECT \n" +
                "        s.user_id,\n" +
                "            s.quiz_id,\n" +
                "            q.quiz_name,\n" +
                "            ifnull(SUM(s.student_score), 0) AS std_grade,\n" +
                "            q.grade AS quiz_grade\n" +
                "    FROM\n" +
                "    course_std cor_std \n" +
                "    LEFT JOIN student_answer s ON cor_std.std_id = s.user_id\n" +
                "    LEFT JOIN quiz q ON s.quiz_id = q.id\n" +
                "    WHERE\n" +
                "        cor_std.cor_id = ?\n" +
                "    GROUP BY cor_std.std_id,s.quiz_id) q9 ON q0.user_id = q9.user_id\n" +
                "        AND q9.quiz_name = 'quiz9'\n" +
                "\t LEFT JOIN\n" +
                "    (SELECT \n" +
                "        s.user_id,\n" +
                "            s.quiz_id,\n" +
                "            q.quiz_name,\n" +
                "            ifnull(SUM(s.student_score), 0) AS std_grade,\n" +
                "            q.grade AS quiz_grade\n" +
                "    FROM\n" +
                "    course_std cor_std \n" +
                "    LEFT JOIN student_answer s ON cor_std.std_id = s.user_id\n" +
                "    LEFT JOIN quiz q ON s.quiz_id = q.id\n" +
                "    WHERE\n" +
                "        cor_std.cor_id = ?\n" +
                "    GROUP BY cor_std.std_id,s.quiz_id) q10 ON q0.user_id = q10.user_id\n" +
                "        AND q10.quiz_name = 'quiz10'\n" +
                "        ";

        List result= this.jdbc.query(sql, new QuizVTORM(), courseID, courseID, courseID, courseID,courseID,courseID,courseID,courseID,courseID,courseID,courseID);
return result;
    }

}
