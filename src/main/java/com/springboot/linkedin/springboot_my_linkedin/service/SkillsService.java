package com.springboot.linkedin.springboot_my_linkedin.service;

import com.springboot.linkedin.springboot_my_linkedin.model.Skills;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import com.springboot.linkedin.springboot_my_linkedin.repository.RegistrationRepository;
import com.springboot.linkedin.springboot_my_linkedin.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService {

    @Autowired
    private SkillsRepository srepo;

    public Skills saveUser(Skills user){
        return srepo.save(user);

    }
}
