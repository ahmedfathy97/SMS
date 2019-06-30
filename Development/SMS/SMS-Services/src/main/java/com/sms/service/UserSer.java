package com.sms.service;
import com.sms.model.course.CourseResultSet;
import com.sms.model.course.LectureVTO;
import com.sms.model.user.UserResultSet;
import com.sms.model.user.UserVTO;
import com.sms.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public UserResultSet findAllUsers(int pageNum)
    {
        UserResultSet resultSet = new UserResultSet();
        List<UserVTO> userVTOList =userRep.findAll(pageNum) ;
        resultSet.setUserList(userVTOList);
        int count = userRep.findALLUsersCount();
        resultSet.setTotalRecords(count);
        return resultSet;

    }


}
