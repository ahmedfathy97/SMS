package com.sms.model.user;

import java.io.Serializable;

public class UserVTO implements Serializable {
    int id;
    String fullName;
    int age;
    String gender;
    String e_mail;
    int phone;
    String college;

    public UserVTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "UserVTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", phone=" + phone +
                ", college='" + college + '\'' +
                '}';
    }
}
