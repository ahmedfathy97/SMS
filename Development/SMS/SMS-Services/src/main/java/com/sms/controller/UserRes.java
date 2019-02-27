package com.sms.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/user")
public class UserRes {

    @GET
    @Path("/{userID}")
    @Produces(MediaType.APPLICATION_JSON)
    public void findByID( int userID){

    }
}
