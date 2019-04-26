package com.sms.model.lookUp.rm;

import com.sms.model.lookUp.CollegeVTO;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CollegeVTORM implements RowMapper<CollegeVTO> {
    public CollegeVTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        CollegeVTO college=new CollegeVTO();
        college.setId(rs.getInt("id"));
        college.setLabelEN(rs.getString("label_en"));
        return college;

    }
}
