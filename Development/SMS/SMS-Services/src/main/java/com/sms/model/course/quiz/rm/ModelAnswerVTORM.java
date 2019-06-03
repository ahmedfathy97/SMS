package com.sms.model.course.quiz.rm;

import com.sms.model.course.quiz.ModelAnswerVTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelAnswerVTORM implements RowMapper<ModelAnswerVTO> {
    @Override
    public ModelAnswerVTO mapRow(ResultSet rs, int rowindex) throws SQLException {
        ModelAnswerVTO modelAnswerVTO =new ModelAnswerVTO() ;
        modelAnswerVTO.setQuestionID(rs.getInt("id"));
        modelAnswerVTO.setModelAnswer(rs.getString("model_answer"));
        modelAnswerVTO.setQuestionGrade(rs.getInt("question_grade"));
        return modelAnswerVTO;
    }
}
