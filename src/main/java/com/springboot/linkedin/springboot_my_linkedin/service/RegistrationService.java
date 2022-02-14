package com.springboot.linkedin.springboot_my_linkedin.service;

import com.springboot.linkedin.springboot_my_linkedin.model.Profile;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import com.springboot.linkedin.springboot_my_linkedin.repository.ProfileRepository;
import com.springboot.linkedin.springboot_my_linkedin.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repo;
    @Autowired
    private ProfileRepository prepo;
    public User saveUser(User user){
       User newUser = repo.save(user);
        prepo.save(new Profile(user.getUserName(),user.getEmailId(),newUser));
         return newUser;

    }
    public User fetchUserByEmailId(String email){
         return repo.findByEmailId(email);
    }
    public User fetchUserByEmailIdAndPassword(String email,String password){
        return repo.findByEmailIdAndPassword(email,password);
    }
}
