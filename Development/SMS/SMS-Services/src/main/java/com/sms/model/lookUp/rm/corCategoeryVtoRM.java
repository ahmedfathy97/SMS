package com.sms.model.lookUp.rm;

import com.sms.model.lookUp.corCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class corCategoeryVtoRM implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowIndex) throws SQLException {
        corCategory category = new corCategory();
        category.setID(rs.getInt("id"));
        category.setLabelEn(rs.getString("label_en"));
        return category;
    }
}
