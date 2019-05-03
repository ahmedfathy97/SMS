package com.sms.repository;

//import com.sms.model.lookUp.rm.UserDataRM;
import com.sms.model.user.UserVTO;
import com.sms.model.user.rm.UserVTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRep {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserVTO findUserByID(int userID) {
        String sql = "SELECT user_id ,concat(first_name , ' ' ,last_name) AS full_name ," +
                "first_name,last_name,age,gender,email,phone,s.username " +
                "FROM user_detail d " +
                "left join auth_user s " +
                "on d.user_id = s.id " +
                "where user_id =?";
        List<UserVTO> user = this.jdbcTemplate.query(sql, new RowMapper<UserVTO>() {
            @Override
            public UserVTO mapRow(ResultSet rs, int i) throws SQLException {
                UserVTO data=new UserVTO();
                data.setId(rs.getInt("user_id"));
                data.setFullName(rs.getString("full_name"));
                data.setFirstName(rs.getString("first_name"));
                data.setLastName(rs.getString("last_name"));
                data.setAge(rs.getInt("age"));
                data.setGender(rs.getString("gender"));
                data.setEmail(rs.getString("email"));
                data.setPhone(rs.getInt("phone"));
                //data.setCollege(rs.getString("college"));
                data.setUserName(rs.getString("username"));
                return data;
            }
        }, userID);
        return user.get(0);
    }


    public void updateUserVto(int userID ,UserVTO userVTO){
        String sql= "update user_detail " +
                "set first_name=?,last_name=?,age=?,gender=?,email=?,phone=? " +
                "where user_id =?" ;

        this.jdbcTemplate.update(sql,userVTO.getFirstName() ,userVTO.getLastName() ,userVTO.getAge(),userVTO.getGender(),userVTO.getEmail() ,userVTO.getPhone() ,userID);


    }




    public List<UserVTO> findAll(){

        String sql="SELECT  user_id,concat(first_name , ' ' ,last_name) AS full_name ,birth_date,col.labelEN as college_name," +
                "co.labelEN as country_name,uni.labelEN  as university_name FROM user_detail ud " +
                "left join college col  on ud.college_id=col.id " +
                "left join country co on ud.country_id=co.id " +
                "left join university uni on ud.university_id=uni.id ";

        List<UserVTO> users= this.jdbcTemplate.query(sql, new RowMapper<UserVTO>() {
            @Override
            public UserVTO mapRow(ResultSet rs, int i) throws SQLException {
                UserVTO data = new UserVTO();
                data.setId(rs.getInt("user_id"));
                data.setFullName(rs.getString("full_name"));
                data.setCollege(rs.getString("college_name"));
                data.setCountry(rs.getString("country_name"));
                data.setUniversity(rs.getString("university_name"));
                data.setBirth_date(rs.getString("birth_date"));


                return data;
            }
        });
        return users;

    }

}
