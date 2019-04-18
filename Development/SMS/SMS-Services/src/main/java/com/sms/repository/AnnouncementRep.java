package com.sms.repository;

import com.sms.model.course.Announcement;
import com.sms.model.course.rm.AnnouncmentVTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnnouncementRep {
    private JdbcTemplate jdbc;

    @Autowired
    public AnnouncementRep(JdbcTemplate jdbc) {
        this.jdbc = jdbc;

    }


}
