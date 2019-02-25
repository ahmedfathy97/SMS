package com.sms.model.lookUp.rm;

import com.sms.model.lookUp.CorType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//TODO: Youssef - rename CLass to CorTypeVTORM
public class CorTypeVTORM implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int roWIndex) throws SQLException {
        CorType type = new CorType();
        type.setId(rs.getInt("id"));
        type.setLabelEN(rs.getString("label_en"));
        return type;
    }
}
