package com.springboot.linkedin.springboot_my_linkedin.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Skills {

    @Id
    private int s_id;
    private String skill;

    public Skills() {

    }

    public Skills(int s_id, String skill) {
        this.s_id = s_id;
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }
}
