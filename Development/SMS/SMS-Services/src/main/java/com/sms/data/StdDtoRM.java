package com.sms.data;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StdDtoRM implements RowMapper<StdDto> {
    @Override
    public StdDto mapRow(ResultSet rs, int rowIndex) throws SQLException {
        StdDto data=new StdDto();
        String firstName=rs.getString("first_name");
        String lastName=rs.getString("last_name");

        data.setFullName(firstName + " " +lastName);
        data.setId(rs.getInt("id"));
        return data;
    }
}
