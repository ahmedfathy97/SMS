package com.sms.repository;

import com.sms.model.CorDetails;
import com.sms.model.course.QuizDTO;
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
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public CourseRep(JdbcTemplate jdbc) {
        this.jdbcTemplate = jdbc;
    }

    public List<CourseVTO> findAllInstructorCourses (int instrID) {
        String sql = "SELECT id,cor_name FROM course where instructor_id =? ";
        return this.jdbcTemplate.query(sql, new CourseVTORM(), instrID);
    }

    //TODO: Youssef - rename to insertNewCourse
    public void addCourseData(CorDetails details){
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
        String sql ="INSERT INTO quiz ( quiz_name, grade, due_date, course_id) VALUES (? ,? ,?,?);\n" ;
        this.jdbcTemplate.update(sql,quizData.getQuizName() ,quizData.getGrade() ,quizData.getDueDate() ,courseID);
    }

}
