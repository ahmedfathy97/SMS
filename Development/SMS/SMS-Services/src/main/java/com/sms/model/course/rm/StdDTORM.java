package com.sms.model.course.rm;

import com.sms.model.course.StdDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//TODO: Hala - move to model/course/rm
//TODO: Hala - rename CLass to StdDTORM
public class StdDTORM implements RowMapper<StdDTO> {
    @Override
    public StdDTO mapRow(ResultSet rs, int rowIndex) throws SQLException {
        StdDTO data=new StdDTO();
        String firstName=rs.getString("first_name");
        String lastName=rs.getString("last_name");

        data.setFullName(firstName + " " +lastName);
        data.setId(rs.getInt("id"));
        return data;
    }
}
