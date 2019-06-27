package com.sms.service;

import com.sms.model.security.LoginDTO;
import com.sms.model.security.RegisterDTO;
import com.sms.model.security.AuthUserVTO;
import com.sms.model.security.RolesVTO;
import com.sms.model.user.UserVTO;
import com.sms.repository.SecurityRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SecuritySer {

    private SecurityRep securityRep;
    private SecurityManagerSer securityManagerSer;

    @Autowired
    public SecuritySer(SecurityRep securityRep,
                       SecurityManagerSer securityManagerSer){
        this.securityRep = securityRep;
        this.securityManagerSer = securityManagerSer;
    }

    public AuthUserVTO login(LoginDTO data) throws Exception{
        UserVTO user = this.securityRep.selectByUserName(data.getUsername());


        if(user == null)
            throw new Exception("User isnot found in the system");
        else {
            String hashedPassword = this.securityManagerSer.dm5Hash(data.getPassword());
            if(!user.getPassword().equals(hashedPassword))
                throw new Exception("USR-0002");
            else{

                String token = this.securityManagerSer.generateToken(user.getUsername(), user.getPassword(), new Date().getTime());

                AuthUserVTO authUser = new AuthUserVTO();
                authUser.setFullName(user.getFirstName() + " " + user.getLastName());
                authUser.setUserID(user.getId());
                authUser.setToken(token);
                authUser.setActionIDs(this.securityRep.getUserActions(user.getId()));
                authUser.setViewIDs(this.securityRep.getUserViews(user.getId()));
                return authUser;
            }
        }
    }

    public void register(RegisterDTO data) throws Exception{
        String hashedPassword = this.securityManagerSer.dm5Hash(data.getPassword());
        data.setPassword(hashedPassword);

        this.securityRep.insertUser(data);
    }


    public List<RolesVTO> getAllRoles() throws Exception {
          return  this.securityRep.getAllRoles() ;
    }
}
