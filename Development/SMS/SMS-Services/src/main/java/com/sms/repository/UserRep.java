package com.sms.repository;

import com.sms.model.lookUp.rm.UserVTORM;
import com.sms.model.user.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRep {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserData findUserByID(int userID) {
        String sql = "SELECT id ,concat(first_name , ' ' ,last_name) AS full_name ,age,gender,e_mail,phone,college,user_name FROM auth_user u \n" +
                "WHERE  u.id= ? ";

        List<UserData> user = this.jdbcTemplate.query(sql, new UserVTORM(), userID);
        return user.get(0);
    }


    public void updateUserData(int userID ,UserData userData){
        String sql= "" ;

        this.jdbcTemplate.update(sql ,userData.getUserName(),userData.getFirstName() ,userData.getLastName() ,userData.getAge() ,userData.getE_mail() ,userData.getGender() ,userData.getPhone() ,userData.getCollege() ,userID);


    }



}
