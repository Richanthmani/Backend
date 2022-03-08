package com.springboot.linkedin.springboot_my_linkedin.controller;

import com.springboot.linkedin.springboot_my_linkedin.model.Profile;
import com.springboot.linkedin.springboot_my_linkedin.model.Skills;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import com.springboot.linkedin.springboot_my_linkedin.service.ProfileService;
import com.springboot.linkedin.springboot_my_linkedin.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateprofile/{userId}")
    public Profile updateProfileById(@RequestBody Profile profile, @PathVariable int userId) throws Exception {
        return service.fetchProfileByIdAfterUpdation(profile, userId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getprofile/{userId}")
    public Profile getProfile(@PathVariable User userId) throws Exception {
        return service.fetchProfileByuserId(userId);
    }
}