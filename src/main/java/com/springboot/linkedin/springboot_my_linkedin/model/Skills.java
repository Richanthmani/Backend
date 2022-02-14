package com.springboot.linkedin.springboot_my_linkedin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String skill;

    @ManyToOne
    @JoinColumn(name="userId")
    @JsonIgnore
    private User userId;

    public Skills( ) {

    }

    public Skills(String skill, User userId) {
        this.skill = skill;
        this.userId = userId;
    }



    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
