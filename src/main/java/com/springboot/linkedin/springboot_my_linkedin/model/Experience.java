package com.springboot.linkedin.springboot_my_linkedin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String company;
    private String role;
    private Date endDate;
    private Date startDate;
    private String location;
    @ManyToOne
    @JoinColumn(name="userId")
    @JsonIgnore
    private User userId;


    public Experience() {
    }

    public Experience(String company, String role, String location, Date endDate, Date startDate, User userId) {
        this.company = company;
        this.role = role;
        this.location = location;
        this.endDate = endDate;
        this.startDate = startDate;
        this.userId = userId;

    }






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
