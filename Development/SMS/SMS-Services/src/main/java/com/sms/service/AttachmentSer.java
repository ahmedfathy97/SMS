package com.sms.service;

//import com.sms.controller.AttachmentRes;

import com.sms.configuration.ConfigManager;
import com.sms.model.attachment.File;
import com.sms.repository.AttachmentRep;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.sql.SQLException;
import java.util.List;

@Service
public class AttachmentSer {
    private AttachmentRep attachmentRep;

    @Autowired
    public AttachmentSer(AttachmentRep attachmentRep) {
        this.attachmentRep = attachmentRep;
    }

    /*********************************** Storage and Database OPs ********************************************/
    public void saveFile(InputStream file, File attachment) {
        // Store on disk
        String fileSrcID = null;
        try {
            if (attachment.getFileSourceID() == 1)
                fileSrcID = "attachment";
            else
                fileSrcID = "assignment";

            // Relative Path
            Path filePath = Paths.get(ConfigManager.ATTACHMENT_PATH  + "/course " + attachment.getCorID() + "//lecture " + attachment.getSourceID()
                    + "//" + fileSrcID + "//" + FilenameUtils.removeExtension(attachment.getName()) + "." + attachment.getExtension());

//            System.err.println(filePath.toString());
//            System.err.println(filePath.toAbsolutePath().toString());
//            System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));

            Files.createDirectories(filePath.getParent());
            Files.copy(file, filePath);
            attachment.setFile_path(filePath.toString());
            file.close();
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists with the same name: " + attachment.getName());
//            java.nio.file.Path path = FileSystems.getDefault().getPath("/Users/bebo/Documents/Files/" +"("+ 2 +")" + name);
//
//            try{
//                Files.copy(file, path);
//            }
//
//            catch (IOException ie) {
//                ie.printStackTrace();
//                System.out.println("File was not saved");
//                return;
//            }
            return;
        } catch (IOException ie) {
            ie.printStackTrace();
            System.out.println("File was not saved");
            return;
        }

        // Insert into database
        this.attachmentRep.insertNewFile(attachment);
    }

    /***************************************** Delete Files ********************************************/
    public void deleteFile(int fileID) {
        File file = this.attachmentRep.getFile(fileID);
        Path path = Paths.get(file.getFile_path());
        System.out.println("Path:::: "+file.getFile_path());
        try {
            Files.deleteIfExists(path);
            System.out.println("The file named: " + file.getName() + " was deleted");
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
         } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
         } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
         }

//        try ng
//            this.attachmentRep.deleteFile(fileID);
//        } catch (Exception e) {
//            System.err.println("Got an exception! ");
//            System.err.println(e.getMessage());
//        }


    }

    /***************************************** Get File from DB ********************************************/
//    public java.io.File fileFromDb(int fileID){
////        File fileFromRep = this.attachmentRep.getFile(fileID);
////        if(fileFromRep != null){
////            java.io.File file = new java.io.File(fileFromRep.getFile_path());
////            return file;
////         }else {
////            return null;
////        }
//
//    }

}
