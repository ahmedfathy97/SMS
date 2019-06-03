package com.sms.model.course.quiz.rm;

import com.sms.model.course.ExamInformationVTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamInformationVTORM  implements RowMapper<ExamInformationVTO> {
    @Override
    public ExamInformationVTO mapRow(ResultSet rs, int rowindex) throws SQLException {
        ExamInformationVTO examInformationVTO =new ExamInformationVTO() ;
        examInformationVTO.setExamName(rs.getString("exam_name"));
        examInformationVTO.setGrade(rs.getInt("grade"));
        examInformationVTO.setNumberofstudentanswers(rs.getInt("numberofstudentanswers"));
        return examInformationVTO ;
    }
}
