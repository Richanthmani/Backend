package com.springboot.linkedin.springboot_my_linkedin.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String emailId;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "userId")
    private List<Skills> skill;

    @OneToOne(mappedBy = "userId")
    private Profile profile;

    @OneToMany(mappedBy = "userId")
    private List<Education> education;

    @OneToMany(mappedBy = "userId")
    private List<Experience> experience;

    public User() {

    }


    public User( String emailId, String userName, String password) {

        this.emailId = emailId;
        this.userName = userName;
        this.password = password;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
