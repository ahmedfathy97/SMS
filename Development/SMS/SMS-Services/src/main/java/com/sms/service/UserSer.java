package com.sms.service;
import com.sms.model.user.UserVTO;
import com.sms.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSer {
    private UserRep userRep;
    @Autowired
    public UserSer(UserRep userRep){
        this.userRep=userRep;
    }

    public UserVTO findByID(int userID) {

        return this.userRep.findUserByID(userID);
    }



}
