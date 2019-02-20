package com.sms.model.lookUp.rm;

import com.sms.model.lookUp.QuestionType;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionTypeRM implements org.springframework.jdbc.core.RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowIndex) throws SQLException {
        QuestionType questionType =new QuestionType();
        questionType.setId(rs.getInt("id"));
        questionType.setLabelEN(rs.getString("label_en"));
        return questionType ;
    }


}
