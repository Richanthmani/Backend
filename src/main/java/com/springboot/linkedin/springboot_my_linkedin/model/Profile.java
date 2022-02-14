package com.springboot.linkedin.springboot_my_linkedin.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String emailId;
    private String fullName;
    private String image;
    private String phoneNumber;
    private String gender;
    private String about;
    private Date DOB;

    @OneToOne
    @JoinColumn(name="userId")
    private User userId;

    public Profile(String emailId, String fullName, String image, String phoneNumber, String gender, String about, Date DOB, User userId) {
        this.emailId = emailId;
        this.fullName = fullName;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.about = about;
        this.DOB = DOB;
        this.userId = userId;
    }

    public Profile(String fullName, String emailId,User userId) {
        this.userId=userId;
        this.fullName= fullName;
        this.emailId=emailId;

    }

    public Profile() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
