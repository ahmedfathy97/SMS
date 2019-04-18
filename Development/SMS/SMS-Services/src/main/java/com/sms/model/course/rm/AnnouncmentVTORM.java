package com.sms.model.course.rm;

import com.sms.model.course.Announcement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnnouncmentVTORM implements RowMapper<Announcement> {
    @Override
    public Announcement mapRow(ResultSet rs, int rowindex) throws SQLException {

        Announcement announcementData  =new Announcement() ;
        announcementData.setTitle(rs.getString("title"));
        announcementData.setContent(rs.getString("content"));
        announcementData.setAnnouncmentDate(rs.getDate("announ_date"));
        return announcementData ;
    }
}
