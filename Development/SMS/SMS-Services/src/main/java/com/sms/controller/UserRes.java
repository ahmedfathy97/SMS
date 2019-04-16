package com.sms.controller;

import com.sms.model.user.UserData;
import com.sms.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserRes {
    @Autowired
    private UserRep userRep;

    @GET
    @Path("/{userID}/profile")
    @Produces(MediaType.APPLICATION_JSON)
    public UserData getUserData(@PathParam("userID") int userID) {
        UserData userData = this.userRep.findUserByID(userID);
        return userData;

    }


    @GET
    @Path("/{userID}/edit")
    @Produces(MediaType.APPLICATION_JSON)
    public void editUserData(@PathParam("userID") int userID ,UserData userData) {

         this.userRep.updateUserData(userID ,userData );


    }
}
