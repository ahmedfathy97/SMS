package com.sms.controller;

import com.sms.model.annotation.Authenticated;
import com.sms.model.authorization.AuthViews;
import com.sms.model.user.UserVTO;
import com.sms.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
public class UserRes {
    private UserRep userRep;
    @Autowired
    public UserRes(UserRep repository) {
        this.userRep =repository ;
    }

    @GET
    @Path("/{userID}/profile")
    @Produces(MediaType.APPLICATION_JSON)
    public UserVTO getUserVto(@PathParam("userID") int userID) {
        UserVTO userVTO = this.userRep.findUserByID(userID);
        return userVTO;

    }


    @GET
    @Path("/{userID}/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editUserData(@PathParam("userID") int userID ,UserVTO userVTO) {

         this.userRep.updateUserVto(userID ,userVTO );


    }
//    @POST
//    @Path("/filter")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void filter(UserList data){
//        System.out.println("Data is received successfully");
//        System.out.println(data.toString());
//
//    }
    @GET
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated(views = {AuthViews.USER_LIST})
    public List<UserVTO> findAllUsers(){
        List<UserVTO> result=this.userRep.findAll();
        return result;

    }
}
