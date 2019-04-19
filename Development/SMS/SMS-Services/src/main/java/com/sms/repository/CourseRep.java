package com.sms.repository;

import com.sms.model.course.*;
import com.sms.model.course.quiz.QuizDTO;
import com.sms.model.course.rm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRep {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<CourseVTO> findAllInstructorCourses(int instrID) {
        String sql = "SELECT id,cor_name,duration ,start_date,end_date, description FROM course where instructor_id =? ";
        return this.jdbcTemplate.query(sql, new CourseVTORM(), instrID);
    }
    public List<CourseVTO> findAllStudentCourse(int stdID){
        String sql ="SELECT cor.id ,std_id,cor_name,duration ,start_date,end_date, description " +
                "FROM course_std  std " +
                "LEFT JOIN course cor on std.cor_id = cor.id " +
                "where std_id = ?";
        return this.jdbcTemplate.query(sql, new CourseVTORM(), stdID);
    }
    public void insertNewCourse(CourseDTO details) {
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

    public List<StdDTO> findAllCourseStudents(int corID) {
        String sql =
                "SELECT first_name, last_name, user_detail.user_id \n" +
                        "                        FROM course_std \n" +
                        "                        LEFT JOIN user_detail user_detail on user_detail.user_id = course_std.std_id \n" +
                        "                        WHERE cor_id = ?";
        return this.jdbcTemplate.query(sql, new StdDTORM(), corID);
    }


    public void insertNewQuiz(int courseID, QuizDTO quizData) {
        String sql = "INSERT INTO quiz ( quiz_name, grade, start_date, close_date , course_id , auto_close ) VALUES (? ,? ,?,? ,? ,?);\n";
        this.jdbcTemplate.update(sql, quizData.getQuizName(), quizData.getGrade(), quizData.getStartDate(), quizData.getFinishDate(), courseID, quizData.isClosed());
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

        CourseVTO course = this.jdbcTemplate.queryForObject(sql, new CourseViewVTORM(), corID);
        return course;

    }

    public List<CourseQuizesVTO> getCourseQuizes(int courseID)
    {
        String sql ="SELECT id ,quiz_name FROM quiz \n" +
                "Where course_id =?;" ;
        return this.jdbcTemplate.query(sql ,new CourseQuizesVTORM(),courseID) ;
    }


    public List<CourseLecturesVTO> getCourseLectures(int courseID)
    {
        String sql ="SELECT id ,title FROM lecture WHERE course_id = ? ;" ;
        return this.jdbcTemplate.query(sql ,new CourseLecturesVTORM() ,courseID) ;
    }


    public void insertNewLecture( int courseID ,LectureDTO data){
        String sql =" INSERT INTO lecture(title , lecture_date , video_url , description ,course_id) Values (?,?,?,?,?) ;\n";

        this.jdbcTemplate.update(sql, data.getTitle(), data.getDate(), data.getVideoUrl(), data.getDescription() ,courseID);

    }


    public void createAnnouncement(int course_id, Announcement announcement) {
        String sql = "INSERT INTO announcment ( title, content , course_id , announ_date)" +
                " Values (?,?,?,?) ";

        this.jdbcTemplate.update(sql, announcement.getTitle(), announcement.getContent(), course_id ,"2019-04-19");

    }



    public List<Announcement> getCourseAnnouncments(int courseID)
    {
        String sql ="SELECT title ,content ,announ_date From announcment \n" +
                "where course_id = ? ;" ;

        return this.jdbcTemplate.query(sql ,new AnnouncmentVTORM() ,courseID);
    }

}