package com.sms.repository;

import com.sms.model.course.CourseDTO;
import com.sms.model.course.QuizDTO;
import com.sms.model.course.StdDTO;
import com.sms.model.course.rm.CourseViewVTORM;
import com.sms.model.course.rm.StdDTORM;
import com.sms.model.course.CourseVTO;
import com.sms.model.course.rm.CourseVTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRep {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseRep(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }


    public List<CourseVTO> findAllInstructorCourses (int instrID) {
        String sql = "SELECT id,cor_name FROM course where instructor_id =? ";
        return this.jdbcTemplate.query(sql, new CourseVTORM(), instrID);
    }

    //TODO: Youssef - rename to insertNewCourse
    public void insertNewCourse(CourseDTO details){
        String sql = "INSERT INTO course(cor_name , duration ,start_date , end_date ," +
                " category_id ,type_id , level_id , description ,instructor_id) Values (?,?,?,?,?,?,?,?,1) ";

        this.jdbcTemplate.update(sql,
                details.getCourseName(),
                details.getDuration(),
                details.getStartDate(),
                details.getEndDate(),
                details.getCategoryID(),
                details.getTypeID(),
                details.getLevelID(),
                details.getDescription());
    }

    public List<StdDTO> findAllCourseStudents(int corID){
        String sql=
                "SELECT first_name, last_name, std.id " +
                        "FROM course_std " +
                        "LEFT JOIN auth_user std on std.id = course_std.std_id " +
                        "WHERE cor_id = ? ";
        return this.jdbcTemplate.query(sql, new StdDTORM(), corID);
    }


    public void insertNewQuiz(int courseID,QuizDTO quizData)
    {
        String sql ="INSERT INTO quiz ( quiz_name, grade, start_date, close_date , course_id , auto_close ) VALUES (? ,? ,?,? ,? ,?);\n" ;
        this.jdbcTemplate.update(sql,quizData.getQuizName() ,quizData.getGrade() ,quizData.getStartDate() ,quizData.getFinishDate() ,courseID , quizData.isClosed());
    }

    public CourseVTO findByID(int corID) {
        String sql = "SELECT \n" +
                "c.cor_name,\n" +
                "c.duration, \n" +
                "c.start_date,\n" +
                "c.end_date,\n" +
                "concat(u.first_name,u.last_name) as Instructor_Name,\n" +
                "c.description ,\n" +
                "COALESCE(t.cat_count, 0) AS course_std,\n" +
                "g.label_en cor_category,\n" +
                "cor_t.label_en cor_type, \n" +
                "l.label_en cor_level \n" +
                "FROM course c \n" +
                "LEFT JOIN auth_user u ON c.instructor_id = u.id\n" +
                "LEFT JOIN cor_category g ON c.category_id = g.id\n" +
                "LEFT JOIN cor_type cor_t ON c.type_id = cor_t.id\n" +
                "LEFT JOIN cor_level l ON c.level_id = l.id\n" +
                "LEFT JOIN(\n" +
                "SELECT cor_id , COUNT(*) AS cat_count\n" +
                "FROM course_std\n" +
                "GROUP BY cor_id ) t\n" +
                "ON c.id = t.cor_id \n" +
                "WHERE c.id = ?";

            CourseVTO course = this.jdbcTemplate.queryForObject(sql , new CourseViewVTORM(),corID);
            return  course;

}

    }