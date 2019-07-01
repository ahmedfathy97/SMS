package com.sms.model.attachment;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class File implements Serializable {

    private int id;
    private String name;
    private String contentType;
    private String extension;
    private long size;
    private String file_path;
    private java.util.Date upload_date;
    private int corID;
    private int sourceID;
    private int fileSourceID;
    private java.util.Date start_date;
    private java.util.Date end_date;

    public File() {
    }

    public File(int id, String name, String contentType, String extension, long size, String file_path, Date upload_date, int corID, int sourceID, int fileSourceID) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
        this.extension = extension;
        this.size = size;
        this.file_path = file_path;
        this.upload_date = upload_date;
        this.corID = corID;
        this.sourceID = sourceID;
        this.fileSourceID = fileSourceID;
    }

    public File(int id, String name, String contentType, String extension, long size, Date upload_date, int corID, int sourceID, int fileSourceID) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
        this.extension = extension;
        this.size = size;
        this.upload_date = upload_date;
        this.corID = corID;
        this.sourceID = sourceID;
        this.fileSourceID = fileSourceID;
    }

//    public File(String name, String contentType, String extension, int size, int sourceID) {
//
////        this.id = id;
//        this.name = name;
//        this.contentType = contentType;
//        this.extension = extension;
//        this.size = size;
////        this.file_path = file_path;
//        this.sourceID = 222;
////        this.fileSourceID = fileSourceID;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public Date getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(Date upload_date) {
        this.upload_date = upload_date;
    }

    public void setUpload_date() {
        this.upload_date = new Date();
    }

    public int getSourceID() {
        return sourceID;
    }

    public void setSourceID(int sourceID) {
        this.sourceID = sourceID;
    }

    public int getFileSourceID() {
        return fileSourceID;
    }

    public void setFileSourceID(int fileSourceID) {
        this.fileSourceID = fileSourceID;
    }

    public int getCorID() {
        return corID;
    }

    public void setCorID(int corID) {
        this.corID = corID;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        if (this.fileSourceID == 1)
            return;
        String pattern = "yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            this.start_date = simpleDateFormat.parse(start_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        if (this.fileSourceID == 1)
            return;

        String pattern = "yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            this.end_date = simpleDateFormat.parse(end_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                ", extension='" + extension + '\'' +
                ", size=" + size +
                ", file_path='" + file_path + '\'' +
                ", upload_date=" + upload_date +
                ", corID=" + corID +
                ", sourceID=" + sourceID +
                ", fileSourceID=" + fileSourceID +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
