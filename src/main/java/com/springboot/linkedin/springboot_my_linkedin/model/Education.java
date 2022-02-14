package com.springboot.linkedin.springboot_my_linkedin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private float score;
    private String Institution;
    private String major;
    public String degree;
    private Date endDate;
    private Date startDate;
    private String location;
    @ManyToOne
    @JoinColumn(name="userId")
    @JsonIgnore
    private User userId;





    public Education(){

    }

    public Education(String institution, String degree, String major, String location, float score, Date endDate, Date startDate, User userId) {
        this.score = score;
        this.Institution = institution;
        this.major = major;
        this.degree = degree;
        this.endDate = endDate;
        this.startDate = startDate;
        this.userId = userId;
        this.location=location;

    }






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getInstitution() {
        return Institution;
    }

    public void setInstitution(String institution) {
        Institution = institution;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
