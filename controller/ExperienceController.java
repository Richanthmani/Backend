package com.springboot.linkedin.springboot_my_linkedin.controller;

import com.springboot.linkedin.springboot_my_linkedin.model.Education;
import com.springboot.linkedin.springboot_my_linkedin.model.Experience;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import com.springboot.linkedin.springboot_my_linkedin.service.EducationService;
import com.springboot.linkedin.springboot_my_linkedin.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ExperienceController {

    @Autowired
    private ExperienceService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addexperience/{userId}")
    public Experience addExperience(@RequestBody Experience experience, @PathVariable int userId) throws Exception {
        Experience experienceObj = null;
        experienceObj = service.saveExperience(experience,userId);
        return experienceObj;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getexperience/{userId}")
    public List<Experience> getExperience(@PathVariable User userId) throws Exception{
        return service.fetchExperienceByuserId(userId);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteexperience/{userId}/{id}")
    public List<Experience> deleteExperienceById( @PathVariable int id,@PathVariable int userId) throws Exception{
        return service.fetchExperienceByIdAfterDeletion(id,userId);
    }
}

