package com.sms.model.course.quiz.rm;

import com.sms.model.course.quiz.QuizDTO;
import com.sms.model.course.quiz.QuizInformationVTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizInformationVTORM implements RowMapper<QuizInformationVTO> {

    @Override
    public QuizInformationVTO mapRow(ResultSet rs, int rowindex) throws SQLException {
        QuizInformationVTO quizInformationVTO =new QuizInformationVTO() ;
        quizInformationVTO.setQuizName(rs.getString("quiz_name"));
        quizInformationVTO.setGrade(rs.getInt("grade"));
        quizInformationVTO.setStartDate(rs.getDate("start_date"));
        quizInformationVTO.setFinishDate(rs.getDate("close_date"));
        quizInformationVTO.setNumberofStudentsAnswers(rs.getInt("numberofstudentanswers"));
        return quizInformationVTO ;
    }
}
