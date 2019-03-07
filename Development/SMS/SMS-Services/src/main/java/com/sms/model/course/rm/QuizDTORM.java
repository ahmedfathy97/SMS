package com.sms.model.course.rm;

import com.sms.model.course.QuizDTO;
import com.sms.model.course.StdDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizDTORM implements RowMapper<QuizDTO> {

    @Override
    public QuizDTO mapRow(ResultSet rs, int rowIndex) throws SQLException {

        QuizDTO quizData =new QuizDTO();
        quizData.setFinishDate(rs.getDate("close_date"));
        return quizData;
    }

}
