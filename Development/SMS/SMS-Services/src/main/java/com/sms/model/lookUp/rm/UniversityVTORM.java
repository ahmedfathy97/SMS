package com.sms.model.lookUp.rm;


import com.sms.model.lookUp.CountryVTO;
import com.sms.model.lookUp.UniversityVTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UniversityVTORM implements RowMapper<UniversityVTO> {
    public UniversityVTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UniversityVTO university=new UniversityVTO();
        university.setId(rs.getInt("id"));
        university.setLabelEN(rs.getString("label_en"));
        return university;

    }
}
