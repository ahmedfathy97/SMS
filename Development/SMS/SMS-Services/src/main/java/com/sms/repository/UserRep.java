package com.sms.repository;

import com.sms.model.lookUp.rm.UserVTORM;
import com.sms.model.user.UserVTO;
import com.sun.org.apache.bcel.internal.generic.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRep {


       private JdbcTemplate jdbc;

        @Autowired
      public UserRep(JdbcTemplate jdbc){
        this.jdbc=jdbc;
    }
    public List<UserVTO> findByID( int userID){
            String sql= "SELECT full_name,age,gender,e_mail,phone,college  FROM user_info u WHERE" +
                    "u.id=?";
    List<UserVTO> user =this.jdbc.query(sql,new UserVTORM(),userID);
       return user;


    }

}