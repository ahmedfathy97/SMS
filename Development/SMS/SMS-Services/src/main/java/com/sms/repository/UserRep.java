package com.sms.repository;

import com.sms.model.lookUp.rm.UserDataRM;
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
        String sql = "SELECT user_id ,concat(first_name , ' ' ,last_name) AS full_name ,age,gender,email,phone,college,s.username FROM user_detail d \n" +
                "                left join auth_user s \n" +
                "                on d.user_id = s.id ;" ;
        List<UserData> user = this.jdbcTemplate.query(sql, new UserDataRM(), userID);
        return user.get(0);
    }


    public void updateUserData(int userID ,UserData userData){
        String sql= "update user_detail " +
                "set first_name=? , last_name=?,age=? gender=?,email=?,phone=?,college=?,user_name=?" +
                "where user_id =?  and id=?" ;

        this.jdbcTemplate.update(sql ,userData.getUserName(),userData.getFirstName() ,userData.getLastName() ,userData.getAge() ,userData.getE_mail() ,userData.getGender() ,userData.getPhone() ,userData.getCollege() ,userID);


    }



}
