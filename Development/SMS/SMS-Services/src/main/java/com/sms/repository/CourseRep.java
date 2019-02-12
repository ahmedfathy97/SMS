package com.sms.repository;

import com.sms.model.CorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRep {
    private JdbcTemplate jdbc ;
    @Autowired
    public CourseRep(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    public void addCourseData(CorDetails details){
        String sql = "INSERT INTO course(cor_name , duration ,start_date , end_date ," +
                " category_id ,type_id , level_id , description ,instructor_id) Values (?,?,?,?,?,?,?,?,1) ";

        this.jdbc.update(sql,
                details.getCourseName(),
                details.getDuration(),
                details.getStartDate(),
                details.getEndDate(),
                details.getCategoryID(),
                details.getTypeID(),
                details.getLevelID(),
                details.getDescription());
    }

}
