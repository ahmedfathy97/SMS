package com.sms.model.course.rm;

import com.sms.model.course.QuestionVTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionVTORM implements org.springframework.jdbc.core.RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowindex) throws SQLException {
        QuestionVTO questionVTO =new QuestionVTO() ;
        questionVTO.setId(rs.getInt("id"));
        questionVTO.setQuestionTypeID(rs.getInt("quiz_question_type_id"));
        questionVTO.setQuestion(rs.getString("question"));
        questionVTO.setAnswer1(rs.getString("answer1"));
        questionVTO.setAnswer2(rs.getString("answer2"));
        questionVTO.setAnswer3(rs.getString("answer3"));
        questionVTO.setAnswer4(rs.getString("answer4"));
        return questionVTO;
    }
}
