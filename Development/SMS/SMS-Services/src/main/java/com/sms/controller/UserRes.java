package com.sms.controller;

import com.sms.model.annotation.Authenticated;
import com.sms.model.authorization.AuthViews;
import com.sms.model.user.UserResultSet;
import com.sms.model.user.UserVTO;
import com.sms.repository.UserRep;
import com.sms.service.UserSer;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Path("/user")
public class UserRes {
    private UserRep userRep;
    private UserSer userSer;
    @Autowired
    public UserRes(UserRep repository,
                   UserSer userSer) {
        this.userRep =repository ;
        this.userSer = userSer;
    }

    @GET
    @Path("/{userID}/profile")
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated(views = {AuthViews.USER_PROFILE})
    public UserVTO getUserVto(@PathParam("userID") int userID) {
        UserVTO userVTO = this.userRep.findUserByID(userID);
        return userVTO;

    }


    @POST
    @Path("/{userID}/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Authenticated(views = {AuthViews.USER_EDIT})
    public void editUserVto(@PathParam("userID") int userID ,UserVTO userVTO) {

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
    public UserResultSet findAllUsers(@QueryParam("pageNum") int pageNum){
        //List<UserVTO> userVTOList=this.userRep.findAll(pageNum);

        return this.userSer.findAllUsers(pageNum);

    }
    @Path("/{userID}/img")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadCourseImg(@PathParam("userID") int userID,
                                    @QueryParam("fileName") String name,
                                    @QueryParam("fileType") String type,
                                    @QueryParam("ext") String ext,
                                    @FormDataParam("file") InputStream fileContent,
                                    @FormDataParam("file") FormDataContentDisposition fileDisposition) throws IOException {

        java.nio.file.Path path = Paths.get("../user/" + userID + "/profileImg/" + name);
        Files.createDirectories(Paths.get("../user/" + userID + "/profileImg/"));
        Files.copy(fileContent, path);

        this.userRep.updateProfileImgByID(userID,name);

        return Response.ok().build();
    }

    @Path("/{userID}/img")
    @GET
    @Produces("image/png")
    public Response getProfileImg(@PathParam("userID") int userID) throws FileNotFoundException {
        String imgPath = this.userRep.findProfileImgByID(userID);

        if(imgPath != null){
            File file = new File("../user/" + userID + "/profileImg/" + imgPath);
            return Response.ok(new FileInputStream(file), MediaType.APPLICATION_OCTET_STREAM).build();
        } else
            return Response.status(404).entity("Profile not found").build();

    }

}
