package com.springboot.linkedin.springboot_my_linkedin.service;

import com.springboot.linkedin.springboot_my_linkedin.model.Skills;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import com.springboot.linkedin.springboot_my_linkedin.repository.RegistrationRepository;
import com.springboot.linkedin.springboot_my_linkedin.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsService {

    @Autowired
    private SkillsRepository srepo;
    @Autowired
    private RegistrationRepository repo;



    public Skills saveSkill(Skills skill,int userId){
        return srepo.save(new Skills(skill.getSkill(),repo.findById(userId)));

    }
    public List<Skills> fetchSkillByuserId(User userId){

        return srepo.findByUserId(userId);
    }


    public Skills fetchSkillByUserIdAndSkill(User userId,String Skill){
        return srepo.findByUserIdAndSkill(userId,Skill);
    }
    public List<Skills> fetchSkillByIdAfterDeletion(int id,int userId){

        srepo.deleteById(id);
        return srepo.findByUserId(repo.findById(userId));
    }

    public List<Skills> fetchSkillByIdAfterUpdation(Skills skill,int userId){
        skill.setUserId(repo.findById(userId));
        srepo.save(skill);
        return srepo.findByUserId(repo.findById(userId));

    }
}
