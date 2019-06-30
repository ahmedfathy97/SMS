package com.sms.model.user;

import java.io.Serializable;
import java.util.List;

public class UserResultSet  implements Serializable {
    private int totalRecords;
    private List<UserVTO> userVTOList;

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<UserVTO> getUserList() {
        return userVTOList;
    }

    public void setUserList(List<UserVTO> userList) {
        this.userVTOList = userList;
    }
}
