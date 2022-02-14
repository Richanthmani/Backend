package com.springboot.linkedin.springboot_my_linkedin.repository;

import com.springboot.linkedin.springboot_my_linkedin.model.Profile;
import com.springboot.linkedin.springboot_my_linkedin.model.Skills;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository  extends JpaRepository<Profile,Integer> {

    public Profile findByUserId(User userId);

}
