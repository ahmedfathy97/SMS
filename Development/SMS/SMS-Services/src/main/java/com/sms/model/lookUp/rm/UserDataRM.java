package com.sms.model.lookUp.rm;

import com.sms.model.user.UserData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataRM implements RowMapper<UserData> {
    @Override
    public UserData mapRow(ResultSet rs, int rowIndex) throws SQLException {

        UserData data=new UserData();
        data.setFullName(rs.getString("full_name"));
        data.setAge(rs.getInt("age"));
        data.setGender(rs.getString("gender"));
        data.setE_mail(rs.getString("email"));
        data.setPhone(rs.getInt("phone"));
        //data.setCollege(rs.getString("college"));
        data.setUserName(rs.getString("username"));
        return data;
    }
}
