package com.sms.repository;

import com.sms.data.StdDto;
import com.sms.data.StdDtoRM;
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


    //TODO: Hala - rename function to findAllCourseStudents
    //TODO: Hala - move function to CourseRes
    public List<StdDto> findStdByCorID(int corID){
        String sql=
            "SELECT first_name, last_name, std.id " +
            "FROM course_std " +
                "LEFT JOIN auth_user std on std.id = course_std.std_id " +
            "WHERE cor_id = ? ";
        return this.jdbc.query(sql, new StdDtoRM(), corID);
    }


    public void insertStudentGrd( int cor_id, StdDto data) {
        String sql = "update course_std "+
       " SET  mid_1_grd=?, semi_final_grd=?, mid_2_grd=?, final_grd=? "+
        "WHERE   cor_id=? AND  std_id = ? ";
        this.jdbc.update(sql,data.getMidTermOne(), data.getSemiFinal(),data.getMidTermTwo(),
                data.getFinal(),cor_id, data.getId());

    }
}
