package com.springboot.linkedin.springboot_my_linkedin.controller;

import com.springboot.linkedin.springboot_my_linkedin.model.Skills;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import com.springboot.linkedin.springboot_my_linkedin.repository.RegistrationRepository;
import com.springboot.linkedin.springboot_my_linkedin.repository.SkillsRepository;
import com.springboot.linkedin.springboot_my_linkedin.service.RegistrationService;
import com.springboot.linkedin.springboot_my_linkedin.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
public class SkillsController {

    @Autowired
    private SkillsService service;

    @Autowired
    private RegistrationRepository repo;

    @Autowired
    private SkillsRepository srepo;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addskill/{userId}")
    public Skills addSkill(@RequestBody Skills skill, @PathVariable int userId) throws Exception {
        String tempSkill = skill.getSkill();
        User tempId = repo.findById(userId);
        if (tempSkill != null && tempSkill != "") {
            Skills skillObj = service.fetchSkillByUserIdAndSkill(tempId, tempSkill);
            if (skillObj != null) {
                throw new Exception("this skill " + tempSkill + " is already added");
            }
        }
        if (tempSkill == "") {
            throw new Exception("please enter a skill");
        }
        Skills skillObj = null;
        skillObj = service.saveSkill(skill, userId);
        return skillObj;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getskills/{userId}")
    public List<Skills> getSKills(@PathVariable User userId) throws Exception {
        return service.fetchSkillByuserId(userId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteskills/{userId}/{id}")
    public List<Skills> deleteSkillById(@PathVariable int id, @PathVariable int userId) throws Exception {
        return service.fetchSkillByIdAfterDeletion(id, userId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateskill/{userId}")
    public List<Skills> updateSkillById(@RequestBody Skills skill, @PathVariable int userId) throws Exception {
       /* String tempSkill = skill.getSkill();
        User tempId = repo.findById(userId);
        if (tempSkill != null && tempSkill != "") {
            Skills skillObj = service.fetchSkillByUserIdAndSkill(tempId, tempSkill);
            if (skillObj != null) {
                throw new Exception("this skill " + tempSkill + " is already added");
            }
        }
        if (tempSkill == "") {
            throw new Exception("please enter a skill");
        }*/

        return service.fetchSkillByIdAfterUpdation(skill,userId);

    }
}

