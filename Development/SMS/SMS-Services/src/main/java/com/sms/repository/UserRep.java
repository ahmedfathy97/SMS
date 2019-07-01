package com.sms.repository;

//import com.sms.model.lookUp.rm.UserDataRM;
import com.sms.configuration.ConfigManager;
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
        String sql = "SELECT \n" +
                "    user_id,\n" +
                "    CONCAT(first_name, ' ', last_name) AS full_name,\n" +
                "    first_name,\n" +
                "    last_name,\n" +
                "    floor(datediff(curdate(), birth_date) / 365) AS age, " +
                "    gender,\n" +
                "    email,\n" +
                "    phone,\n" +
                "    s.username\n" +
                "FROM\n" +
                "    user_detail d\n" +
                "        LEFT JOIN\n" +
                "    auth_user s ON d.user_id = s.id\n" +
                "WHERE\n" +
                "    user_id = ?";
        List<UserVTO> user = this.jdbcTemplate.query(sql, new RowMapper<UserVTO>() {
            @Override
            public UserVTO mapRow(ResultSet rs, int i) throws SQLException {
                UserVTO data=new UserVTO();
                data.setId(rs.getInt("user_id"));
                data.setFullName(rs.getString("full_name"));
                data.setFirstName(rs.getString("first_name"));
                data.setLastName(rs.getString("last_name"));
                data.setAge(rs.getInt("age"));
//                data.setBirthDate(rs.getString("birth_date"));
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
                "set first_name=?,last_name=?,birth_date=?,gender=?,email=?,phone=? " +
                "where user_id =?" ;

        this.jdbcTemplate.update(sql,userVTO.getFirstName() ,userVTO.getLastName() ,userVTO.getBirthDate(),userVTO.getGender(),userVTO.getEmail() ,userVTO.getPhone() ,userID);


    }

    public String findProfileImgByID(int corID) {
        String sql ="SELECT image_path from user_detail where user_id = ? ";

        List<String> result = this.jdbcTemplate.query(sql , new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("image_path");
            }
        },corID);

        return result.size() != 0 ? result.get(0) : null;
    }

    public void updateProfileImgByID(int userID, String name) {
        String sql = "UPDATE user_detail SET image_path = ? WHERE user_id = ?";

        this.jdbcTemplate.update(sql, name, userID);
    }



    public List<UserVTO> findAll(int pageNum){
        int pageSize = ConfigManager.PAGE_SIZE;
        String sql="SELECT \n" +
                "    user_id,\n" +
                "    CONCAT(first_name, ' ', last_name) AS full_name,\n" +
                "    birth_date,\n" +
                "    col.labelEN AS college_name,\n" +
                "    co.labelEN AS country_name,\n" +
                "    uni.labelEN AS university_name,\n" +
                "    s.username\n" +
                "FROM\n" +
                "    user_detail ud\n" +
                "        LEFT JOIN\n" +
                "    auth_user s ON ud.user_id = s.id\n" +
                "        LEFT JOIN\n" +
                "    college col ON ud.college_id = col.id\n" +
                "        LEFT JOIN\n" +
                "    country co ON ud.country_id = co.id\n" +
                "        LEFT JOIN\n" +
                "    university uni ON ud.university_id = uni.id " +
                "    LIMIT " + pageSize + " OFFSET " + (pageSize * (pageNum-1));

        List<UserVTO> users= this.jdbcTemplate.query(sql, new RowMapper<UserVTO>() {
            @Override
            public UserVTO mapRow(ResultSet rs, int i) throws SQLException {
                UserVTO data = new UserVTO();
                data.setId(rs.getInt("user_id"));
                data.setFullName(rs.getString("full_name"));
                data.setCollege(rs.getString("college_name"));
                data.setCountry(rs.getString("country_name"));
                data.setUniversity(rs.getString("university_name"));
                data.setBirthDate(rs.getString("birth_date"));
                data.setUserName(rs.getString("username"));
                return data;
            }
        });
        return users;

    }
    public int findALLUsersCount() {
        String sql = "SELECT COUNT(*) AS record_count " +
                "FROM user_detail ud " ;


        List<Integer> totalCount = this.jdbcTemplate.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt("record_count");
            }
        });
        return totalCount.get(0);
    }

}
