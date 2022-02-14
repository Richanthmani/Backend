package com.springboot.linkedin.springboot_my_linkedin.service;

import com.springboot.linkedin.springboot_my_linkedin.model.Profile;
import com.springboot.linkedin.springboot_my_linkedin.model.Skills;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import com.springboot.linkedin.springboot_my_linkedin.repository.ProfileRepository;
import com.springboot.linkedin.springboot_my_linkedin.repository.RegistrationRepository;
import com.springboot.linkedin.springboot_my_linkedin.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfileService {

    @Autowired
    private ProfileRepository prepo;
    @Autowired
    private RegistrationRepository repo;


    public Profile fetchProfileByuserId(User userId){

        return prepo.findByUserId(userId);
    }
    public Profile fetchProfileByIdAfterUpdation(Profile profile, int userId){
        profile.setUserId(repo.findById(userId));
       return prepo.save(profile);
        //   return prepo.findByUserId(repo.findById(userId));
}



}

