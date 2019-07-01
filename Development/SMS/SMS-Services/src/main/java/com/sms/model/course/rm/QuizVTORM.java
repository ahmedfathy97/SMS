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


        QuizVTO quiz4 = new QuizVTO();
        quiz4.setStdScore(rs.getInt("q4_std_grade"));
        quiz4.setTotalScore(rs.getInt("q4_quiz_grade"));
        data.getQuizes().add(quiz4);


        QuizVTO quiz5 = new QuizVTO();
        quiz5.setStdScore(rs.getInt("q5_std_grade"));
        quiz5.setTotalScore(rs.getInt("q5_quiz_grade"));
        data.getQuizes().add(quiz5);

        QuizVTO quiz6 = new QuizVTO();
        quiz6.setStdScore(rs.getInt("q6_std_grade"));
        quiz6.setTotalScore(rs.getInt("q6_quiz_grade"));
        data.getQuizes().add(quiz6);



        QuizVTO quiz7 = new QuizVTO();
        quiz7.setStdScore(rs.getInt("q7_std_grade"));
        quiz7.setTotalScore(rs.getInt("q7_quiz_grade"));
        data.getQuizes().add(quiz7);


        QuizVTO quiz8 = new QuizVTO();
        quiz8.setStdScore(rs.getInt("q8_std_grade"));
        quiz8.setTotalScore(rs.getInt("q8_quiz_grade"));
        data.getQuizes().add(quiz8);



        QuizVTO quiz9 = new QuizVTO();
        quiz9.setStdScore(rs.getInt("q9_std_grade"));
        quiz9.setTotalScore(rs.getInt("q9_quiz_grade"));
        data.getQuizes().add(quiz9);


        QuizVTO quiz10 = new QuizVTO();
        quiz10.setStdScore(rs.getInt("q10_std_grade"));
        quiz10.setTotalScore(rs.getInt("q10_quiz_grade"));
        data.getQuizes().add(quiz10);








        return data;
    }
}
