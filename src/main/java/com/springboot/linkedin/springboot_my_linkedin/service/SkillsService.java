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


    public Skills skillExists(Skills skill,int userId) throws Exception{
        String tempSkill = skill.getSkill();
        User tempId = repo.findById(userId);
        if (tempSkill != null && tempSkill != "") {
            Skills skillObj = this.fetchSkillByUserIdAndSkill(tempId, tempSkill);
            if (skillObj != null) {
                throw new Exception("this skill " + tempSkill + " is already added");
            }
        }
        if (tempSkill == "") {
            throw new Exception("please enter a skill");
        }
        Skills skillObj = null;

        return skillObj;
    }

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
