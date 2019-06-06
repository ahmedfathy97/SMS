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
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
//    /* Upload Multiple Files */
//    @Path("/files")
//    @POST
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response uploadFiles(@FormDataParam("files") List<FormDataBodyPart> bodyParts,
//                                @FormDataParam("files") FormDataContentDisposition fileDispositions,
//                                @FormDataParam("file") List<String> json) {
//
//        StringBuffer fileDetails = new StringBuffer("");
//        /* Save multiple files */
//        for (int i = 0; i < bodyParts.size(); i++) {
//            try {
//                BodyPartEntity bodyPartEntity = (BodyPartEntity) bodyParts.get(i).getEntity();
//                String fileName = bodyParts.get(i).getContentDisposition().getFileName();
//                String filePath = "/Users/bebo/Documents/Files" + fileDispositions.getFileName();
//                fileDetails.append(" File saved at /Users/bebo/Documents/Files/" + fileName);
//
//                ObjectMapper mapper = new ObjectMapper();
//
//                File file = mapper.readValue(json.get(i), File.class);
//                file.setFile_path(filePath);
//                file.setSourceID(i);
//                file.setUpload_date();
//                this.service.saveFile(bodyPartEntity.getInputStream(), fileName, file);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return Response.ok(fileDetails.toString()).build();
//    }

    /*******************************************************************************/
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{fileID}")
//    public List<File> getFilesByCategoryID(
////            @PathParam("fileID") int categoryID
//    ) throws IOException {
////        List<java.io.File> files;
////        try (Stream<java.nio.file.Path> paths = Files.walk(Paths.get("/Users/bebo/Documents/Files"))) {
////            paths
////                    .filter(Files::isRegularFile)
////                    .forEach(System.out::println);
////        }
////      catch (IOException e){
////            e.printStackTrace();
////      }
////        java.io.File f = null;
////        String[] paths;
////        try {
////            // create new file
////            f = new java.io.File("/Users/bebo/Documents/Files");
////            // array of files and directory
////            paths = f.list();
////            // for each name in the path array
////            for(String path:paths)
////                // prints filename and directory name
////                System.out.println(path);
////        } catch(Exception e) {
////            // if any error occurs
////            e.printStackTrace();
////        }
//        return null;
//    }

    /***********************************Delete Files********************************************/

    @DELETE
    @Path("/{fileID}")
    @Authenticated(actions = {AuthActions.ADD_MATERIAL})
    public void removeFile(@PathParam("fileID") int fileID) {
        this.service.deleteFile(fileID);
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
            @FormDataParam("file") InputStream fileContent,
            @FormDataParam("file") FormDataContentDisposition fileDisposition)
    {
//        removeFile(152);
        String fileName = fileDisposition.getFileName();
        String filePath = "/Users/bebo/Documents/Files/";

        File file = new File();
        file.setName(name);
        file.setContentType(type);
        file.setSize(size);
        file.setExtension(ext);
        file.setFile_path(filePath + name);
        file.setSourceID(sourceID);
        file.setFileSourceID(fileSrcID);
        file.setUpload_date();

        String fileDetails = "File saved at " + filePath;

//        System.out.println(file.toString());
        service.saveFile(fileContent, name, file);
        return Response.ok(fileDetails).build();

    }

    /*********************************** Retrieve List of Files ********************************************/

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/files")
//    @Authenticated(views = {AuthViews.LECTURE_DETAILS})

    public List<File> listFiles(@QueryParam("sourceID") int sourceID,
                                @QueryParam("fileSrcID") int fileSrcID)
    {
        List<File> files = this.repository.findFiles(sourceID ,fileSrcID);
//        System.out.println(files.get(0).toString());
        return files;

    }

//    /* Download Files */
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/downloadFile/{fileID}")
    @Authenticated(actions = {AuthActions.DOWNLOAD_MATERIAL})

    public Response downloadFileById(@PathParam("fileID") int fileID) throws IOException{
        File fileFromRep = this.repository.getFile(fileID);

        java.io.File file = new java.io.File(fileFromRep.getFile_path());
        java.nio.file.Path filePath = Paths.get(file.getAbsolutePath());

        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(filePath));

        return Response.ok().entity(resource.getByteArray()).type(fileFromRep.getContentType()).build();
//
    }


}