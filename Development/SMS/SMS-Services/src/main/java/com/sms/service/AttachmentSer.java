package com.sms.service;

import com.sms.controller.AttachmentRes;
import com.sms.model.attachment.File;
import com.sms.repository.AttachmentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.List;

@Service
public class AttachmentSer {
    private AttachmentRep attachmentRep;
    @Autowired
    public AttachmentSer(AttachmentRep attachmentRep){
        this.attachmentRep = attachmentRep;
    }

    /*********************************** Storage and Database OPs ********************************************/
    public void saveFile(InputStream file, String name, File attachment) {
        // Store on disk
        try {
            java.nio.file.Path path = FileSystems.getDefault().getPath("/Users/bebo/Documents/Files/" + name);
            Files.copy(file, path);
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists with the same name: " + name);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        // Insert into database
        this.attachmentRep.insertNewFile(attachment);
    }

    /*********************************** Get Files from DB ********************************************/
    public void getFiles(){

    }
//    public static void getFile(){
//    Path wiki_path = Paths.get("/Users/bebo/Documents/Files","1.txt");
//
//    try {
//        byte[] wikiArray = Files.readAllBytes(wiki_path);
//
//        String wikiString = new String(wikiArray, "UTF-8");
//        System.out.println(wikiString);
//    } catch (
//    IOException e) {
//        System.out.println(e);
//    }
//    }

    /************************************** Storing Files *****************************************/

}
