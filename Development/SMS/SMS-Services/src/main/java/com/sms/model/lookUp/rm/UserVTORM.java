package com.sms.model.lookUp.rm;

import com.sms.model.user.UserVTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserVTORM implements RowMapper<UserVTO> {
    @Override
    public UserVTO mapRow(ResultSet rs, int rowIndex) throws SQLException {

        UserVTO data=new UserVTO();
        String firstName=rs.getString("first_name");
        String lastName=rs.getString("last_name");
        data.setId(rs.getInt("id"));
        data.setFullName(firstName + " " +lastName);
        data.setAge(rs.getInt("age"));
        data.setGender(rs.getString("gender"));
        data.setE_mail(rs.getString("e_mail"));
        data.setPhone(rs.getInt("phone"));
        data.setCollege(rs.getString("college"));
        return data;
    }
}
