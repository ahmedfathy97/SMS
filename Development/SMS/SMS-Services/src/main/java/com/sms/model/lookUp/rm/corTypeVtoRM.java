package com.sms.model.lookUp.rm;

import com.sms.model.lookUp.corType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//TODO: Youssef - rename CLass to CorTypeVTORM
public class corTypeVtoRM implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int roWIndex) throws SQLException {
        corType type = new corType();
        type.setID(rs.getInt("id"));
        type.setLabelEn(rs.getString("label_en"));
        return type;
    }
}
