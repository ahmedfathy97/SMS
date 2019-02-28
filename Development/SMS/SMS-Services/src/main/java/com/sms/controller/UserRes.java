package com.sms.controller;

import com.sms.model.user.UserVTO;
import com.sms.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
public class UserRes {
    @Autowired
    private UserRep repository;
    @GET
    @Path("/{userID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserVTO> userData(@PathParam("userID") int userID) {
       List<UserVTO> data = this.repository.findByID(userID);
      return data;

    }
}
