package com.sms.model.attachment;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FileRm implements RowMapper<File> {
    @Override
    public File mapRow(ResultSet rs, int rowIndex) throws SQLException {
        File file = new File();
        file.setId(rs.getInt("file_id"));
        file.setName(rs.getString("file_name"));
        file.setSize(rs.getInt("file_size"));
        file.setContentType(rs.getString("content_type"));
        file.setUpload_date(rs.getDate("upload_date"));
        file.setSourceID(rs.getInt("source_id"));


        System.out.println(file.toString());
        return file;
    }

}
