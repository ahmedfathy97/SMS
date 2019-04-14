package com.sms.repository;

import com.sms.model.lookUp.rm.EditVTORM;
import com.sms.model.user.EditVto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EditRep {

    private JdbcTemplate jdbc;

    @Autowired
    public EditRep(JdbcTemplate jdbc){
        this.jdbc=jdbc;
    }
    public EditVto findByID(int userID){
        String sql= "SELECT id ,concat(first_name , ' ' ,last_name) AS full_name ,age,gender,e_mail,phone,college,user_name FROM auth_user u \n" +
                "WHERE  u.id= ? " ;


        List<EditVto> user =this.jdbc.query(sql,new EditVTORM(),userID);
        return user.get(0);


    }
}
