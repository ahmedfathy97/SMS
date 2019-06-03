package com.sms.repository;

import com.sms.model.course.StdDTO;
import com.sms.model.course.rm.CourseGradesRM;
import com.sms.model.course.rm.StdDTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class GradeRep {
    private JdbcTemplate jdbc;
    @Autowired

    public GradeRep(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }





    public void insertMidTermOne( int cor_id, StdDTO data) {
        String sql = "update course_std "+
       " SET  mid_1_grd=?  "+
        "WHERE   cor_id=? AND  std_id = ? ";
        this.jdbc.update(sql,data.getNewGrade(),cor_id, data.getId());

    }
    public void insertSemiFinal( int cor_id, StdDTO data) {
        String sql = "update course_std "+
                " SET  semi_final_grd=?  "+
                "WHERE   cor_id=? AND  std_id = ? ";
        this.jdbc.update(sql,data.getNewGrade(),cor_id, data.getId());

    }
    public void insertMidTermTwo( int cor_id, StdDTO data) {
        String sql = "update course_std "+
                " SET  mid_2_grd=?  "+
                "WHERE   cor_id=? AND  std_id = ? ";
        this.jdbc.update(sql,data.getNewGrade(),cor_id, data.getId());

    }
    public void insertFinalGrd( int cor_id, StdDTO data) {
        String sql = "update course_std "+
                " SET  final_grd=?  "+
                "WHERE   cor_id=? AND  std_id = ? ";
        this.jdbc.update(sql, data.getNewGrade(),cor_id, data.getId());

    }
    public List<StdDTO> findCourseGrades(int courseID,int pageNum){
        int pageSize = 2;
        String sql ="SELECT std.first_name,std.last_name,std.user_id,\n" +
                "                               cor.mid_1_grd,cor.semi_final_grd,cor.mid_2_grd,cor.final_grd\n" +
                "                               from user_detail std\n" +
                "                                left join course_std cor\n" +
                "                               on std.user_id=cor.std_id\n" +
                "                                where cor_id=1\n" +
                "                                LIMIT "+pageSize+"offest"+ (pageSize* (pageNum-1));


        return this.jdbc.query(sql, new CourseGradesRM(), courseID);


    }
    public StdDTO findStudentGrades(int courseID,int stdID){
        String sql ="SELECT std.first_name,std.last_name,std.user_id,\n" +
                "                cor.mid_1_grd,cor.semi_final_grd,cor.mid_2_grd,cor.final_grd\n" +
                "                from user_detail std\n" +
                "                   left join course_std cor\n" +
                "                on std.user_id=cor.std_id\n" +
                "where cor_id=?"+
                "                And std.user_id=?\n" ;


        StdDTO std = this.jdbc.queryForObject(sql, new CourseGradesRM(), courseID,stdID );

        return std;
    }
}
