package com.springboot.linkedin.springboot_my_linkedin.repository;


import com.springboot.linkedin.springboot_my_linkedin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository  extends JpaRepository <User,Integer> {
    public User findByEmailId(String emailId);
    public User findByEmailIdAndPassword(String emailId,String password);


}
