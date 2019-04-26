package com.sms.model.lookUp.rm;


import com.sms.model.lookUp.CollegeVTO;
import com.sms.model.lookUp.CountryVTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryVTORM implements RowMapper<CountryVTO> {
    public CountryVTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        CountryVTO country=new CountryVTO();
        country.setId(rs.getInt("id"));
        country.setLabelEN(rs.getString("label_en"));
        return country;

    }
}
