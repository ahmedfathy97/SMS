package com.sms.model.lookUp.rm;

import com.sms.model.lookUp.CorLevel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//TODO: Youssef - rename CLass to CorLevelVTORM
public class CorLevelVTORM implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowIndex) throws SQLException {
        CorLevel level = new CorLevel();
        level.setId(rs.getInt("id"));
        level.setLabelEN(rs.getString("label_en"));
        return level;
    }
}
