package com.springboot.linkedin.springboot_my_linkedin.repository;

import com.springboot.linkedin.springboot_my_linkedin.model.Skills;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository <Skills, Integer> {


}
