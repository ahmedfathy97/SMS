package com.sms.controller;


import com.sms.model.security.AuthUserVTO;
import com.sms.model.security.LoginDTO;
import com.sms.model.security.RegisterDTO;
import com.sms.model.security.RolesVTO;
import com.sms.repository.SecurityRep;
import com.sms.service.SecuritySer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class SecurityRes {


    private SecurityRep securityRep;
    private SecuritySer securitySer;

    @Autowired
    public SecurityRes(SecurityRep securityRep,
                       SecuritySer securitySer){
        this.securityRep = securityRep;
        this.securitySer = securitySer;
    }

    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void register(RegisterDTO data) throws Exception {
        this.securitySer.register(data);
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginDTO data) throws Exception {
        AuthUserVTO authUserVTO = this.securitySer.login(data);
        return Response.ok().entity(authUserVTO).build();
    }

    @Path("/roles")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RolesVTO> getAllRoles() throws Exception {
        return this.securitySer.getAllRoles() ;
    }


}
