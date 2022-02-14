package com.springboot.linkedin.springboot_my_linkedin.repository;

import com.springboot.linkedin.springboot_my_linkedin.model.Education;
import com.springboot.linkedin.springboot_my_linkedin.model.Skills;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education,Integer> {

    public List<Education> findByUserId(User userId);

}
