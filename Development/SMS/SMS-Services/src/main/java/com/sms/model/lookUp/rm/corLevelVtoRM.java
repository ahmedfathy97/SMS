package com.sms.model.lookUp.rm;

import com.sms.model.lookUp.corLevel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//TODO: Youssef - rename CLass to CorLevelVTORM
public class corLevelVtoRM implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowIndex) throws SQLException {
        corLevel level = new corLevel();
        level.setID(rs.getInt("id"));
        level.setLabelEn(rs.getString("label_en"));
        return level;
    }
}
