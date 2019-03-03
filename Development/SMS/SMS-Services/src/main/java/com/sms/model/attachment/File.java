package com.sms.model.attachment;

import java.io.Serializable;
import java.util.Date;

public class File implements Serializable {

    private int id;
    private String name;
    private String type;
    private String extension;
    private long size;
    private String file_path;
    private java.util.Date upload_date;
    private int sourceID;
    private int fileSourceID;

    public File() {
    }

    public File(int id, String name, String type, String extension, long size, String file_path, Date upload_date, int sourceID, int fileSourceID) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.extension = extension;
        this.size = size;
        this.file_path = file_path;
        this.upload_date = upload_date;
        this.sourceID = sourceID;
        this.fileSourceID = fileSourceID;
    }

    public File(String name, String type, String extension, int size, int sourceID) {

//        this.id = id;
        this.name = name;
        this.type = type;
        this.extension = extension;
        this.size = size;
//        this.file_path = file_path;
        this.sourceID = 222;
//        this.fileSourceID = fileSourceID;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", extension='" + extension + '\'' +
                ", size=" + size +
                ", file_path='" + file_path + '\'' +
                ", upload_date=" + upload_date +
                ", sourceID=" + sourceID +
                ", fileSourceID=" + fileSourceID +
                '}';
    }
}
