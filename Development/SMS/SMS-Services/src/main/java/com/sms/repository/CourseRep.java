package com.sms.repository;

import com.sms.configuration.ConfigManager;
import com.sms.model.course.*;
import com.sms.model.course.quiz.QuizDTO;
import com.sms.model.course.rm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CourseRep {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert quizSJI;
    private SimpleJdbcInsert courseSJI;

    @Autowired
    public CourseRep(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        quizSJI = new SimpleJdbcInsert(dataSource).withTableName("quiz").usingGeneratedKeyColumns("id");
        this.jdbcTemplate = jdbcTemplate;
        this.courseSJI = new SimpleJdbcInsert(dataSource).withTableName("course").usingGeneratedKeyColumns("id");

    }

    public boolean isInstructor(int userID, int courseID)
    {
        String sql = "select cor_name from course \n" +
                "where instructor_id = ? \n" +
                "and id = ? ";
        List result = this.jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Object();
            }
        },userID , courseID);

        return result.size() != 0 ;
    }
    public boolean isEnrolled(int userID, int courseID){
        String sql = "select id from course_std \n" +
                "                where std_id = ?\n" +
                "                and cor_id = ?";
        List result = this.jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Object();
            }
        }, userID, courseID);
        return result.size() != 0 ;

    }

    public List<CourseVTO> findAllInstructorCourses(int instrID,int pageNum) {
        int pageSize = ConfigManager.PAGE_SIZE;
        String sql = "SELECT cor.image_path, id,cor_name,duration ,start_date,end_date, description, " +
                "a.first_name, a.last_name  " +
                "FROM course cor " +
                "LEFT JOIN user_detail a on cor.instructor_id = a.user_id " +
                "where cor.instructor_id = ? "+
                "LIMIT " + pageSize + " OFFSET " + (pageSize * (pageNum-1));

        return this.jdbcTemplate.query(sql, new CourseVTORM(), instrID);
    }
    public List<CourseVTO> findALLCourses(int pageNum) {
        int pageSize = ConfigManager.PAGE_SIZE;
        String sql = "SELECT cor.image_path, id,cor_name,duration ,start_date,end_date, description, " +
                "a.first_name, a.last_name  " +
                "FROM course cor " +
                "LEFT JOIN user_detail a on cor.instructor_id = a.user_id " +
                "LIMIT " + pageSize + " OFFSET " + (pageSize * (pageNum-1)) ;

        return this.jdbcTemplate.query(sql, new CourseVTORM());
    }
    public int findALLCoursesCount() {
        String sql = "SELECT COUNT(*) AS record_count " +
                "FROM course cor " +
                "LEFT JOIN user_detail a on cor.instructor_id = a.user_id ";

        List<Integer> totalCount = this.jdbcTemplate.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt("record_count");
            }
        });
        return totalCount.get(0);
    }

    public int findALLAnnouncementCount() {
        String sql = "SELECT COUNT(*) AS record_count \n" +
                "                FROM  announcment announc\n" +
                "                left join course cor\n" +
                "                on announc.course_id = cor.id;";

        List<Integer> totalCount = this.jdbcTemplate.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt("record_count");
            }
        });
        return totalCount.get(0);
    }
    public int findAllLectureCount(int corID){
        String sql="SELECT COUNT(*) AS record_count \n" +
                "                FROM lecture WHERE course_id = ?";
        List<Integer> totalCount = this.jdbcTemplate.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt("record_count");
            }
        }, corID);
        return totalCount.get(0);


    }
    public List<CourseVTO> findAllStudentCourse(int stdID,int pageNum){
        int pageSize = ConfigManager.PAGE_SIZE;
        String sql ="SELECT cor.image_path, cor.id ,std_id, cor_name, duration , start_date, end_date, " +
                "description, a.first_name, a.last_name " +
                "FROM course_std  std " +
                "LEFT JOIN course cor on std.cor_id = cor.id " +
                "LEFT JOIN user_detail a on cor.instructor_id = a.user_id " +
                "where std_id = ? "+
                "LIMIT " + pageSize + " OFFSET " + (pageSize * (pageNum-1)) ;
        return this.jdbcTemplate.query(sql, new CourseVTORM(), stdID);
    }

    public int  insertNewCourse( int instructorID ,CourseDTO details) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("cor_name",details.getCourseName());
        parameters.put("duration", details.getDuration());
        parameters.put("start_date", details.getStartDate());
        parameters.put("end_date", details.getEndDate());
        parameters.put("category_id",details.getCategoryID());
        parameters.put("type_id", details.getTypeID());
        parameters.put("level_id", details.getLevelID());
        parameters.put("description", details.getDescription());
        parameters.put("instructor_id", instructorID);

        int id = this.courseSJI.executeAndReturnKey(parameters).intValue() ;

        String sql2 = "INSERT INTO exam(exam_name , grade , course_id ) Values (?,?,?) ";
        this.jdbcTemplate.update(sql2,"Mid Term",details.getMidOneGrd(),id);
        this.jdbcTemplate.update(sql2,"Final Term",details.getFinalGrd(),id);

        return id ;
    }

    public List<StdDTO> findAllCourseStudents(int corID , int stdID) {
        String sql =
                "SELECT first_name, last_name, user_detail.user_id \n" +
                        "                        FROM course_std \n" +
                        "                        LEFT JOIN user_detail user_detail on user_detail.user_id = course_std.std_id \n" +
                        "                        WHERE cor_id = ?"+
                        ((stdID != -1 ) ? " AND course_std.std_id = ?" : "") ;
        return ((stdID != -1 ) ? this.jdbcTemplate.query(sql, new StdDTORM(), corID , stdID ) :
                this.jdbcTemplate.query(sql, new StdDTORM(), corID  )) ;
    }
    public List<StdDTO> findAllTypeGrade(int corID) {
        String sql =
                "SELECT first_name, last_name, user_detail.user_id,mid_1_grd,semi_final_grd,\n" +
                        "mid_2_grd,final_grd \n" +
                        "FROM course_std \n" +
                        "LEFT JOIN user_detail user_detail on user_detail.user_id = course_std.std_id \n" +
                        "WHERE cor_id = ?\n";
        return this.jdbcTemplate.query(sql, new RowMapper<StdDTO>() {
            @Override
            public StdDTO mapRow(ResultSet rs, int rowIndex) throws SQLException {
                StdDTO std=new StdDTO();
                String firstName=rs.getString("first_name");
                String lastName=rs.getString("last_name");
                std.setFullName(firstName + " " +lastName);
                std.setId(rs.getInt("user_id"));
                std.setMidTermOne(rs.getInt("mid_1_grd"));
                std.setSemiFinal(rs.getInt("semi_final_grd"));
                std.setMidTermTwo(rs.getInt("mid_2_grd"));
                std.setFinalGrd(rs.getInt("final_grd"));

                return std;
            }
        }, corID);
    }



    public List<StdDTO> findAllStudentsAttendance(int corID , String attendanceDate ) {
        String sql= "select first_name, last_name , u_std.user_id , is_attended"+
                " from course_std c_std left join user_detail u_std on c_std.std_id = u_std.user_id"+
                " left join attendance att on c_std.cor_id = att.cor_id"+
                " left join cor_std_att c_att on att.id = c_att.att_id"+
                " and u_std.user_id = c_att.std_id"+
                " where c_std.cor_id = ?" +
                " and att.created_on = ? " ;
        return this.jdbcTemplate.query(sql, new RowMapper<StdDTO>() {
            @Override
            public StdDTO mapRow(ResultSet rs, int i) throws SQLException {
                StdDTO data=new StdDTO();
                String firstName=rs.getString("first_name");
                String lastName=rs.getString("last_name");
                data.setFullName(firstName + " " +lastName);
                data.setId(rs.getInt("user_id"));
                data.setIsAttend(rs.getBoolean("is_attended"));
                return data;
            }
        }, corID , attendanceDate);
    }


    public int insertNewQuiz(int courseID, QuizDTO quizData) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        Map<String, Object> parameters = new HashMap<>(6);
        parameters.put("quiz_name", quizData.getQuizName());
        parameters.put("grade",quizData.getGrade());
        parameters.put("start_date",dateFormat.format(quizData.getStartDate()));
        parameters.put("close_date",dateFormat.format(quizData.getFinishDate()));
        parameters.put("course_id",courseID);
        parameters.put("is_closed",quizData.isClosed());

        Number newId = quizSJI.executeAndReturnKey(parameters);
        return newId.intValue();
    }




    public CourseVTO findByID(int corID) {
        String sql = "\n" +
                "SELECT \n" +
                "    c.cor_name,\n" +
                "    c.duration,\n" +
                "    c.start_date,\n" +
                "    c.end_date,\n" +
                "    c.instructor_id,\n" +
                "    CONCAT(u.first_name, CONCAT(' ', u.last_name)) AS Instructor_Name,\n" +
                "    c.description,\n" +
                "    COALESCE(t.cat_count, 0) AS course_std,\n" +
                "    g.label_en cor_category,\n" +
                "    cor_t.label_en cor_type,\n" +
                "    l.label_en cor_level\n" +
                "FROM\n" +
                "    course c\n" +
                "        LEFT JOIN\n" +
                "    user_detail u ON c.instructor_id = u.user_id\n" +
                "        LEFT JOIN\n" +
                "    cor_category g ON c.category_id = g.id\n" +
                "        LEFT JOIN\n" +
                "    cor_type cor_t ON c.type_id = cor_t.id\n" +
                "        LEFT JOIN\n" +
                "    cor_level l ON c.level_id = l.id\n" +
                "        LEFT JOIN\n" +
                "    (SELECT \n" +
                "        cor_id, COUNT(*) AS cat_count\n" +
                "    FROM\n" +
                "        course_std\n" +
                "    GROUP BY cor_id) t ON c.id = t.cor_id\n" +
                "WHERE\n" +
                "    c.id = ?;";

        CourseVTO course = this.jdbcTemplate.queryForObject(sql, new CourseViewVTORM(), corID);
        return course;

    }

    public List<CourseQuizesVTO> getCourseQuizes(int courseID)
    {
        String sql ="SELECT id ,quiz_name FROM quiz \n" +
                "Where course_id =?;" ;
        return this.jdbcTemplate.query(sql ,new CourseQuizesVTORM(),courseID) ;
    }

    public List<CourseExamsVTO> getCourseExams(int courseID)
    {
        String sql ="SELECT id ,exam_name FROM exam \n" +
                "Where course_id =?;" ;
        List<CourseExamsVTO> courseExams = this.jdbcTemplate.query(sql, new RowMapper<CourseExamsVTO>() {
            @Override
            public CourseExamsVTO mapRow(ResultSet rs, int i) throws SQLException {
                CourseExamsVTO courseExamsVTO =new CourseExamsVTO() ;
                courseExamsVTO.setExamID(rs.getInt("id"));
                courseExamsVTO.setExamName(rs.getString("exam_name"));
                return courseExamsVTO ;
            }
        }, courseID) ;
        return courseExams ;
    }


    public List<LectureVTO> getCourseLectures(int courseID,int pageNum)
    {
        int pageSize = ConfigManager.PAGE_SIZE;
        String sql ="SELECT id ,title ,lecture_date FROM lecture WHERE course_id = ? " +
                "LIMIT " + pageSize + " OFFSET " + (pageSize * (pageNum-1)) ;


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



    public List<Announcement> getCourseAnnouncments(int courseID , int pageNum)
    {
        int pageSize = ConfigManager.PAGE_SIZE;
        String sql ="SELECT title ,content ,announ_date From announcment \n" +
                "where course_id = ? " +
                "order by announ_date  " +
                "LIMIT " + pageSize + " OFFSET " + (pageSize * (pageNum-1));

        return this.jdbcTemplate.query(sql ,new AnnouncmentVTORM() ,courseID);
    }


    public String findCorImgByID(int corID) {
        String sql ="SELECT image_path from course where id = ? ";

        List<String> result = this.jdbcTemplate.query(sql , new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("image_path");
            }
        },corID);

        return result.size() != 0 ? result.get(0) : null;
    }

    public void updateCorImgByID(int corID, String name) {
        String sql = "UPDATE course SET image_path = ? WHERE id = ?";

        this.jdbcTemplate.update(sql, name, corID);
    }

    public int findALLInstCoursesCount(int instructorID) {
        int pageSize = ConfigManager.PAGE_SIZE;
        String sql = "SELECT COUNT(*) AS record_count  " +
                "FROM course cor " +
                "LEFT JOIN user_detail a on cor.instructor_id = a.user_id " +
                "where cor.instructor_id = ? ";

        return this.jdbcTemplate.query(sql,  new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt("record_count");
            }
        }, instructorID).get(0);
    }

    public int findAllStdCoursesCount(int stdID) {
        int pageSize = ConfigManager.PAGE_SIZE;
        String sql = "SELECT COUNT(*) AS record_count " +
                "FROM course_std  std " +
                "LEFT JOIN course cor on std.cor_id = cor.id " +
                "LEFT JOIN user_detail a on cor.instructor_id = a.user_id " +
                "where std_id = ? ";

        return this.jdbcTemplate.query(sql,  new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt("record_count");
            }
        }, stdID).get(0);
    }
}