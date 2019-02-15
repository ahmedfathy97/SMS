package com.sms.repository;

import com.sms.model.CorDetails;
import com.sms.model.course.StdDTO;
import com.sms.model.course.rm.StdDTORM;
import com.sms.model.course.CourseVTO;
import com.sms.model.course.rm.CourseVTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRep {
    private JdbcTemplate jdbc ;
    @Autowired
    public CourseRep(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<CourseVTO> findAllInstructorCourses (int instrID) {
        String sql = "SELECT id,cor_name FROM course where instructor_id =? ";
        return this.jdbc.query(sql, new CourseVTORM(), instrID);
    }

    //TODO: Youssef - rename to insertNewCourse
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
    //TODO: Hala - rename function to findAllCourseStudents
    //TODO: Hala - move function to CourseRep
    public List<StdDTO> findAllCourseStudents(int corID){
        String sql=
                "SELECT first_name, last_name, std.id " +
                        "FROM course_std " +
                        "LEFT JOIN auth_user std on std.id = course_std.std_id " +
                        "WHERE cor_id = ? ";
        return this.jdbc.query(sql, new StdDTORM(), corID);
    }

}
