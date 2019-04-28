package com.sms.repository;


import com.sms.model.course.StdDTO;
import com.sms.model.course.rm.AttendanceDTORM;
import com.sms.model.course.rm.StdDTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AttendanceRep {

    private JdbcTemplate jdbc ;
    private SimpleJdbcInsert attendanceSJI;

    @Autowired
    public AttendanceRep(JdbcTemplate jdbc, DataSource dataSource) {
        attendanceSJI = new SimpleJdbcInsert(dataSource).withTableName("attendance").usingGeneratedKeyColumns("id");
        this.jdbc = jdbc;
    }

    public int insertNewSheet(int courseID , Date sheetDate){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        String strDate = dateFormat.format(sheetDate);
        Map<String, Object> parameters = new HashMap<>(2);
        parameters.put("cor_id", courseID);
        parameters.put("created_on",strDate);
        Number newId = attendanceSJI.executeAndReturnKey(parameters);
        return newId.intValue();
    }

    public void insertStudentAttendance(int attendanceSheetID, int courseID , StdDTO data){
        String sql = "INSERT INTO cor_std_att ( att_id , cor_id , std_id , is_attended ) value (?,?,?,?)";
        this.jdbc.update(sql , attendanceSheetID, courseID , data.getId() ,data.getIsAttend() ? "1" : "0"); }

    public void updateStudentAttendance(int courseID, String attendanceDate , StdDTO data)
    {
        String sql = "update cor_std_att cor " +
        " left join attendance att on att.id = cor.att_id " +
        " and att.created_on = ? " +
        " set is_attended = ? " +
        " where cor.cor_id = ? " +
        " and cor.std_id = ? " ;

        this.jdbc.update(sql , attendanceDate , data.getIsAttend() ? "1" : "0"  , courseID , data.getId());
    }

    public List<StdDTO> viewAttendSheetInstructor (int corID) {
        String sql= "select first_name, last_name , att.created_on , is_attended"+
       " from course_std c_std left join user_detail u_std on c_std.std_id = u_std.user_id"+
        " left join attendance att on c_std.cor_id = att.cor_id"+
        " left join cor_std_att c_att on att.id = c_att.att_id"+
        " and u_std.user_id = c_att.std_id"+
        " where c_std.cor_id = ?" ;
        return this.jdbc.query(sql, new AttendanceDTORM(), corID);
    }

    public List<StdDTO> findCourseStudent (int corID , int stdID){
        String sql=
                "SELECT first_name, last_name, std.id " +
                        "FROM course_std " +
                        "LEFT JOIN auth_user std on std.id = course_std.std_id " +
                        "WHERE cor_id = ?" +
                        " and std.id = ? ";
        return this.jdbc.query(sql, new StdDTORM(), corID , stdID);
    }

    public List<StdDTO> viewAttendSheetStudent (int corID , int stdID) {
        String sql= "select first_name , last_name , created_on , is_attended"+
                " from course_std c_std left join auth_user u_std on c_std.std_id = u_std.id"+
                " left join attendance att on c_std.cor_id = att.cor_id"+
                " left join cor_std_att c_att on att.id = c_att.att_id"+
                " and u_std.id = c_att.std_id"+
                " where c_std.cor_id = ?" +
                " and u_std.id = ?";
        return this.jdbc.query(sql, new AttendanceDTORM(), corID , stdID);
    }

}
