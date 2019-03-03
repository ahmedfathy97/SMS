package com.sms.repository;

import com.sms.model.attachment.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttachmentRep {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AttachmentRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertNewFile(File file) {
        String sql = "INSERT INTO attachment (file_name, content_type, file_size,extension," +
                "  file_path, upload_date, source_id) VALUES (?, ?, ?, ?, ?, ?, ?) ";

        this.jdbcTemplate.update(sql, file.getName(), file.getType(), file.getSize(), file.getExtension(),
                file.getFile_path(), file.getUpload_date(), file.getSourceID());
    }

//    public List<File> getFileById(int source_id){
//        String sql = "SELECT * from attachment where source_id = ?";
//
//        return this.jdbcTemplate.query(sql,new File(),source_id);
//    }

//    public void removeFile(int id){
//        String sql = "DELETE from attachment where id =?";
//        this.jdbcTemplate.update(sql,id);
//    }


}
