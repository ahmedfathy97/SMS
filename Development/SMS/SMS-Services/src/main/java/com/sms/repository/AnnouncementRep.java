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

    public void createAnnouncement(int course_id, Announcement announcement) {
        String sql = "INSERT INTO announcement ( title, content , course_id)" +
                " Values (?,?,?) ";

        this.jdbc.update(sql, announcement.getTitle(), announcement.getContent(), course_id);

    }



    public List<Announcement> getCourseAnnouncments(int courseID)
    {
       String sql ="SELECT title ,content ,announ_date From announcment \n" +
               "where course_id = ? ;" ;

       return this.jdbc.query(sql ,new AnnouncmentVTORM() ,courseID);
    }
}
