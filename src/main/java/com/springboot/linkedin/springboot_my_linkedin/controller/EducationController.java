package com.springboot.linkedin.springboot_my_linkedin.controller;

import com.springboot.linkedin.springboot_my_linkedin.model.Education;
import com.springboot.linkedin.springboot_my_linkedin.model.Skills;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import com.springboot.linkedin.springboot_my_linkedin.service.EducationService;
import com.springboot.linkedin.springboot_my_linkedin.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EducationController {

    @Autowired
    private EducationService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addeducation/{userId}")
    public Education addEducation(@RequestBody Education education,@PathVariable int userId) throws Exception {
        Education educationObj = null;
        educationObj = service.saveEducation(education,userId);
        return educationObj;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/geteducation/{userId}")
    public List<Education> getEducation(@PathVariable User userId) throws Exception{
        return service.fetchEducationByuserId(userId);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteeducation/{userId}/{id}")
    public List<Education> deleteEducationById( @PathVariable int id,@PathVariable int userId) throws Exception{
        return service.fetchEducationByIdAfterDeletion(id,userId);
    }


}
