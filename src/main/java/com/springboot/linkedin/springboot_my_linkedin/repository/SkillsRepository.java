package com.springboot.linkedin.springboot_my_linkedin.repository;

import com.springboot.linkedin.springboot_my_linkedin.model.Skills;

import com.springboot.linkedin.springboot_my_linkedin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillsRepository extends JpaRepository <Skills, Integer> {


    public List<Skills> findByUserId(User userId);
    public Skills findByUserIdAndSkill(User userId,String Skill);

}
