package com.sms.repository;

import com.sms.model.attachment.File;
import com.sms.model.attachment.FileRm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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

        this.jdbcTemplate.update(sql, file.getName(), file.getContentType(), file.getSize(), file.getExtension(),
                file.getFile_path(), file.getUpload_date(), file.getSourceID());
    }

    // For Listing purposes
    public List<File> findFiles(int source_id) {
        String sql = "SELECT file_id, file_name, file_size,content_type, upload_date " +
                "FROM attachment " +
                "WHERE source_id = ?";

        List<File> files = this.jdbcTemplate.query(sql, new FileRm(), source_id);
        return files;
    }

    // For Download purposes
    public File getFile(int fileID) {
        String sql = "SELECT file_path,file_name,content_type,extension FROM attachment WHERE file_id=?";

        List<File> files = this.jdbcTemplate.query(sql, new RowMapper<File>() {
            @Override
            public File mapRow(ResultSet rs, int i) throws SQLException {
                File file = new File();
                file.setFile_path(rs.getString("file_path"));
                file.setContentType(rs.getString("content_type"));
                file.setExtension(rs.getString("extension"));
                file.setName(rs.getString("file_name"));
                System.out.println(file);
                return file;
            }
        }, fileID);
        System.out.println("inside Rep: " + files.get(0));
        return files.get(0);
    }

    public void deleteFile(int id){
//        String sql = "DELETE FROM attachment where file_id = ?";
//        this.jdbcTemplate.update(sql,new Object[]{id});
//        //        this.jdbcTemplate.update(SQL, id);
//        System.out.println("Deleted Record with ID = " + id );
//        return;

    }


}
