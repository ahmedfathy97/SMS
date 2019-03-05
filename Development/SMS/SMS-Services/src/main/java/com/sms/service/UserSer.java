package com.sms.service;
import com.sms.model.user.UserVTO;
import com.sms.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSer {
    private UserRep userRep;
    @Autowired
    public UserSer(UserRep userRep){
        this.userRep=userRep;
    }

    public  UserVTO findByID( int userID) {

        return this.userRep.findByID(userID);
    }



}
