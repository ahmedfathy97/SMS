package com.sms.model.lookUp.rm;

import com.sms.model.lookUp.CorCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//TODO: Youssef - rename CLass to CorCategoryVTORM
public class CorCategoryVTORM implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowIndex) throws SQLException {
        CorCategory category = new CorCategory();
        category.setId(rs.getInt("id"));
        category.setLabelEN(rs.getString("label_en"));
        return category;
    }
}
