package com.springboot.linkedin.springboot_my_linkedin.repository;

import com.springboot.linkedin.springboot_my_linkedin.model.Education;
import com.springboot.linkedin.springboot_my_linkedin.model.Experience;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository  extends JpaRepository<Experience,Integer> {

    public List<Experience> findByUserId(User userId);

}
