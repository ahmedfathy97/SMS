package com.sms.controller;

import com.sms.model.annotation.Authenticated;
import com.sms.model.attachment.File;
import com.sms.model.authorization.AuthActions;
import com.sms.model.authorization.AuthViews;
import com.sms.repository.AttachmentRep;
import com.sms.service.AttachmentSer;
import org.glassfish.jersey.media.multipart.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@Path("/attachment")
public class AttachmentRes {
    private AttachmentSer service;
    private AttachmentRep repository;

    @Autowired
    public AttachmentRes(AttachmentSer attachmentSer, AttachmentRep attachmentRep) {
        this.service = attachmentSer;
        this.repository = attachmentRep;

    }
    public AttachmentRes() {
    }

    /*********************************** Upload a single File ********************************************/
    /*Output stream version of uploading a single file*/
    @Path("/file")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Authenticated(actions = {AuthActions.ADD_MATERIAL})
    public Response uploadFile(
            @QueryParam("name") String name,
            @QueryParam("type") String type,
            @QueryParam("size") long size,
            @QueryParam("ext") String ext,
            @QueryParam("sourceID") int sourceID,
            @QueryParam("fileSrcID") int fileSrcID,
            @QueryParam("corID") int corID,
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate,
            @FormDataParam("file") InputStream fileContent,
            @FormDataParam("file") FormDataContentDisposition fileDisposition
    ) {
//        removeFile(152);
        String fileName = fileDisposition.getFileName();

        File file = new File();
        file.setName(name);
        file.setContentType(type);
        file.setSize(size);
        file.setExtension(ext);
        file.setSourceID(sourceID);
        file.setCorID(corID);
        file.setFileSourceID(fileSrcID);
        file.setUpload_date();
        file.setStart_date(startDate);
        file.setEnd_date(endDate);

        System.out.println(file.toString());


//        System.out.println(file.toString());
        service.saveFile(fileContent, file);
        return Response.ok(file.toString()).build();

    }

    /***********************************Delete Files********************************************/

    @DELETE
    @Path("/{fileID}")
    @Authenticated(actions = {AuthActions.ADD_MATERIAL})
    public void removeFile(@PathParam("fileID") int fileID) {
        this.service.deleteFile(fileID);
    }

    /*********************************** Retrieve List of Files ********************************************/

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/files")
    @Authenticated(views = {AuthViews.LECTURE_DETAILS})

    public List<File> listFiles(@QueryParam("corID") int corID,
                                @QueryParam("sourceID") int sourceID,
                                @QueryParam("fileSrcID") int fileSrcID) {
        List<File> files = this.repository.findFiles(corID, sourceID, fileSrcID);
//        System.out.println(files.get(0).toString());
        return files;

    }

    //    /* Download Files */
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/downloadFile/{fileID}")
    @Authenticated(actions = {AuthActions.DOWNLOAD_MATERIAL})

    public Response downloadFileById(@PathParam("fileID") int fileID) throws IOException {
        File fileFromRep = this.repository.getFile(fileID);

        java.io.File file = new java.io.File(fileFromRep.getFile_path());

        java.nio.file.Path filePath = Paths.get(file.getPath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(filePath));

        return Response.ok().entity(resource.getByteArray()).type(fileFromRep.getContentType()).build();
//
    }


}