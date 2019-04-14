package com.sms.controller;


import com.sms.model.user.EditVto;
import com.sms.model.user.UserVTO;
import com.sms.repository.EditRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/edit")
public class EditRes {
    @Autowired
    private EditRep repository;
   @GET
   @Path("/{userID}")
   @Produces(MediaType.APPLICATION_JSON)
    public EditVto userData(@PathParam("userID") int userID) {
        EditVto data = this.repository.findByID(userID);
        return data;

    }
}
