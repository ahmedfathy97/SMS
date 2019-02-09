package com.sms.controller;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/security")
public class SecurityRes {


    @Path("/test")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response testService() throws Exception {
        return Response.ok().entity("Spring Application is working fine").build();

    }
}
