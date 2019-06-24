package com.sms.model.course.rm;

import com.sms.model.course.QuizVTO;
import com.sms.model.course.StdDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuizVTORM implements RowMapper<StdDTO> {


    @Override
    public StdDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        StdDTO data=new StdDTO();
//        data.setId(rs.getInt("user_id"));
        String firstName=rs.getString("first_name");
        String lastName=rs.getString("last_name");

        data.setFullName(firstName + " " +lastName);
        data.setQuizes(new ArrayList<>());


        QuizVTO quiz1 = new QuizVTO();
        quiz1.setStdScore(rs.getInt("q1_std_grade"));
        quiz1.setTotalScore(rs.getInt("q1_quiz_grade"));
        data.getQuizes().add(quiz1);

        QuizVTO quiz2 = new QuizVTO();
        quiz2.setStdScore(rs.getInt("q2_std_grade"));
        quiz2.setTotalScore(rs.getInt("q2_quiz_grade"));
        data.getQuizes().add(quiz2);


        QuizVTO quiz3 = new QuizVTO();
        quiz3.setStdScore(rs.getInt("q3_std_grade"));
        quiz3.setTotalScore(rs.getInt("q3_quiz_grade"));
        data.getQuizes().add(quiz3);

        return data;
    }
}
