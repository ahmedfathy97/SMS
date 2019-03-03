package com.sms.controller;

import ch.qos.logback.core.util.Loader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.model.attachment.File;
import com.sms.service.AttachmentSer;
import com.sun.xml.internal.ws.api.ResourceLoader;
import org.glassfish.jersey.media.multipart.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;


@Path("/attachment")
public class AttachmentRes {
    private AttachmentSer service;

    @Autowired
    public AttachmentRes(AttachmentSer attachmentSer) {
        this.service = attachmentSer;
    }

    /* Upload Multiple Files */
    @Path("/files")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response uploadFiles(@FormDataParam("files") List<FormDataBodyPart> bodyParts,
                                @FormDataParam("files") FormDataContentDisposition fileDispositions,
                                @FormDataParam("file") List<String> json) {

        StringBuffer fileDetails = new StringBuffer("");
        /* Save multiple files */
        for (int i = 0; i < bodyParts.size(); i++) {
            try {
                BodyPartEntity bodyPartEntity = (BodyPartEntity) bodyParts.get(i).getEntity();
                String fileName = bodyParts.get(i).getContentDisposition().getFileName();
                String filePath = "/Users/bebo/Documents/Files" + fileDispositions.getFileName();
                fileDetails.append(" File saved at /Users/bebo/Documents/Files/" + fileName);

                ObjectMapper mapper = new ObjectMapper();

                File file = mapper.readValue(json.get(i), File.class);
                file.setFile_path(filePath);
                file.setSourceID(i);
                file.setUpload_date();
                this.service.saveFile(bodyPartEntity.getInputStream(), fileName, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Response.ok(fileDetails.toString()).build();
    }

    /*******************************************************************************/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{fileID}")
    public List<File> getFileById(@PathParam("fileID") int fileID) {

        return null;
    }

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
    public void removeFile(@PathParam("fileID") int id) {

    }

    /*Output stream version of uploading a single file*/
    @Path("/file")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @QueryParam("name") String name,
            @QueryParam("type") String type,
            @QueryParam("size") long size,
            @QueryParam("ext") String ext,
            @FormDataParam("file") InputStream fileContent,
            @FormDataParam("file") FormDataContentDisposition fileDisposition) {

        String fileName = fileDisposition.getFileName();
        String filePath = "/Users/bebo/Documents/Files/";

        File file = new File();
        file.setName(name);
        file.setType(type);
        file.setSize(size);
        file.setExtension(ext);
        file.setFile_path(filePath);
        file.setSourceID(1);
        file.setUpload_date();

        String fileDetails = "File saved at " + filePath;

        System.out.println(file.toString());

        service.saveFile(fileContent, name, file);
        return Response.ok(fileDetails).build();
    }

    /***********************************Delete Files********************************************/
    @Path("view")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<File> getFilesInfo() {

        return null;
    }



























    /* Upload single File
     * Mainly used with Student uploading homework */

//    @Path("/file")
//        @POST
//        @Consumes(MediaType.MULTIPART_FORM_DATA)
//        public Response uploadFile(@DefaultValue("") @FormDataParam("tags") String tags,
//                                   @FormDataParam("file") InputStream file,
//                                   @FormDataParam("file") FormDataContentDisposition fileDisposition,
//                                   @FormDataParam("ID") String id) {
//
//
//             String fileName = fileDisposition.getFileName();
//
//            saveFile(file, fileName);
//
//            String fileDetails = "File saved at /Users/bebo/Documents/" + fileName + " with tags "+ tags;
//
//            System.out.println("ID" + id);
//
//            System.out.println(fileDetails);
//
//            return Response.ok(fileDetails).build();
//        }

}


//    @Path("/files2")
//    @POST
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    public Response uploadFiles(final FormDataMultiPart multiPart) {
//
//        List<FormDataBodyPart> bodyParts = multiPart.getFields("files");
//
//        StringBuffer fileDetails = new StringBuffer("");
//
//        /* Save multiple files */
//        for (int i = 0; i < bodyParts.size(); i++) {
//            BodyPartEntity bodyPartEntity = (BodyPartEntity) bodyParts.get(i).getEntity();
//            String fileName = bodyParts.get(i).getContentDisposition().getFileName();
//            saveFile(bodyPartEntity.getInputStream(), fileName);
//            fileDetails.append(" File saved at /Volumes/Drive2/temp/file/" + fileName);
//        }
//
//        /* Save File 2 */
//
//        BodyPartEntity bodyPartEntity = ((BodyPartEntity) multiPart.getField("file2").getEntity());
//        String file2Name = multiPart.getField("file2").getFormDataContentDisposition().getFileName();
//        saveFile(bodyPartEntity.getInputStream(), file2Name);
//        fileDetails.append(" File saved at /Volumes/Drive2/temp/file/" + file2Name);
//
//        fileDetails.append(" Tag Details : " + multiPart.getField("tags").getValue());
//        System.out.println(fileDetails);
//
//        return Response.ok(fileDetails.toString()).build();
//    }

