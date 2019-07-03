package com.sms.repository;

import com.sms.model.attachment.File;
import com.sms.model.attachment.FileRm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AttachmentRep {
    private JdbcTemplate jdbcTemplate;
//    private AssignmentRep assRep;
private SimpleJdbcInsert attachmentSJI;


    @Autowired
    public AttachmentRep(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.attachmentSJI = new SimpleJdbcInsert(dataSource).withTableName("attachment")
                .usingGeneratedKeyColumns("file_id");
    }

    public int insertNewFile(File file) {

        Map<String, Object> parameters = new HashMap<>(2);
        parameters.put("file_name", file.getName());
        parameters.put("content_type", file.getContentType());
        parameters.put("file_size", file.getSize());
        parameters.put("extension", file.getExtension());
        parameters.put("file_path", file.getFile_path());
        parameters.put("upload_date", file.getUpload_date());
        parameters.put("source_id", file.getSourceID());
        parameters.put("file_src_id", file.getFileSourceID());
        parameters.put("start_date", file.getStart_date());
        parameters.put("end_date", file.getEnd_date());
        parameters.put("cor_id", file.getCorID());

        Number newId = attachmentSJI.executeAndReturnKey(parameters);
        return newId.intValue();

//        String sql = "INSERT INTO attachment (file_name, content_type, file_size,extension," +
//                "  file_path, upload_date, source_id, file_src_id, start_date, end_date, cor_id) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
//
//        this.jdbcTemplate.update(sql, file.getName(), file.getContentType(), file.getSize(), file.getExtension(),
//                file.getFile_path(), file.getUpload_date(), file.getSourceID(), file.getFileSourceID(),
//                file.getStart_date(), file.getEnd_date(), file.getCorID());

//        this.assRep.insertNewAssignment();
    }

    // For Listing purposes
    public List<File> findFiles(int corID, int sourceID, int file_src_id) {
        String sql = "SELECT file_id, file_name, file_size, content_type, upload_date, start_date, end_date " +
                "FROM attachment " +
                "WHERE cor_id = ? AND source_id = ? AND file_src_id = ?  ";

        List<File> files = this.jdbcTemplate.query(sql, new FileRm(), corID, sourceID, file_src_id);
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
//        System.out.println("inside Rep: " + files.get(0));
        return files.get(0);
    }

    public void deleteFile(int id){
        String sql = "DELETE FROM attachment where file_id = ?";
        this.jdbcTemplate.update(sql, id);
        //        this.jdbcTemplate.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
        return;

    }


}
