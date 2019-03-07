//package com.sms.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sms.model.attachment.File;
//import com.sms.repository.AttachmentRep;
//import com.sms.service.AttachmentSer;
//import org.glassfish.jersey.media.multipart.*;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//
//@Path("/attachment")
//public class AttachmentRes {
//    private AttachmentSer service;
//    private AttachmentRep repository;
//
//    @Autowired
//    public AttachmentRes(AttachmentSer attachmentSer, AttachmentRep attachmentRep) {
//        this.service = attachmentSer;
//        this.repository = attachmentRep;
//
//    }
//
////    /* Upload Multiple Files */
////    @Path("/files")
////    @POST
////    @Consumes(MediaType.MULTIPART_FORM_DATA)
////    @Produces(MediaType.TEXT_PLAIN)
////    public Response uploadFiles(@FormDataParam("files") List<FormDataBodyPart> bodyParts,
////                                @FormDataParam("files") FormDataContentDisposition fileDispositions,
////                                @FormDataParam("file") List<String> json) {
////
////        StringBuffer fileDetails = new StringBuffer("");
////        /* Save multiple files */
////        for (int i = 0; i < bodyParts.size(); i++) {
////            try {
////                BodyPartEntity bodyPartEntity = (BodyPartEntity) bodyParts.get(i).getEntity();
////                String fileName = bodyParts.get(i).getContentDisposition().getFileName();
////                String filePath = "/Users/bebo/Documents/Files" + fileDispositions.getFileName();
////                fileDetails.append(" File saved at /Users/bebo/Documents/Files/" + fileName);
////
////                ObjectMapper mapper = new ObjectMapper();
////
////                File file = mapper.readValue(json.get(i), File.class);
////                file.setFile_path(filePath);
////                file.setSourceID(i);
////                file.setUpload_date();
////                this.service.saveFile(bodyPartEntity.getInputStream(), fileName, file);
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
////        return Response.ok(fileDetails.toString()).build();
////    }
//
//    /*******************************************************************************/
////    @GET
////    @Produces(MediaType.APPLICATION_JSON)
////    @Path("/{fileID}")
////    public List<File> getFilesByCategoryID(
//////            @PathParam("fileID") int categoryID
////    ) throws IOException {
//////        List<java.io.File> files;
//////        try (Stream<java.nio.file.Path> paths = Files.walk(Paths.get("/Users/bebo/Documents/Files"))) {
//////            paths
//////                    .filter(Files::isRegularFile)
//////                    .forEach(System.out::println);
//////        }
//////      catch (IOException e){
//////            e.printStackTrace();
//////      }
//////        java.io.File f = null;
//////        String[] paths;
//////        try {
//////            // create new file
//////            f = new java.io.File("/Users/bebo/Documents/Files");
//////            // array of files and directory
//////            paths = f.list();
//////            // for each name in the path array
//////            for(String path:paths)
//////                // prints filename and directory name
//////                System.out.println(path);
//////        } catch(Exception e) {
//////            // if any error occurs
//////            e.printStackTrace();
//////        }
////        return null;
////    }
//
//    /***********************************Delete Files********************************************/
//
//    @DELETE
//    @Path("/{fileID}")
//    public void removeFile(@PathParam("fileID") int id) {
//
//    }
//
//    /*********************************** Upload a single File ********************************************/
//    /*Output stream version of uploading a single file*/
//    @Path("/file")
//    @POST
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    public Response uploadFile(
//            @QueryParam("name") String name,
//            @QueryParam("type") String type,
//            @QueryParam("size") long size,
//            @QueryParam("ext") String ext,
//            @FormDataParam("file") InputStream fileContent,
//            @FormDataParam("file") FormDataContentDisposition fileDisposition) {
//
//        String fileName = fileDisposition.getFileName();
//        String filePath = "/Users/bebo/Documents/Files/";
//
//        File file = new File();
//        file.setName(name);
//        file.setContentType(type);
//        file.setSize(size);
//        file.setExtension(ext);
//        file.setFile_path(filePath);
//        file.setSourceID(1);
//        file.setUpload_date();
//
//        String fileDetails = "File saved at " + filePath;
//
//        System.out.println(file.toString());
////        getFileBySourceId(1);
//        service.saveFile(fileContent, name, file);
//
//        return Response.ok(fileDetails).build();
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/files/{sourceID}")
//    public List<File> getFilesBySourceId(@PathParam("sourceID") int sourceID) {
//        List<File> files = this.repository.findFiles(sourceID);
//        return files;
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/file/{fileID}")
//    public File getFileById(@PathParam("fileID") int fileID) {
//        service.getFile(fileID);
//        return null;
//
//    }
//
//}