package com.springboot.linkedin.springboot_my_linkedin.controller;

import com.springboot.linkedin.springboot_my_linkedin.model.Skills;
import com.springboot.linkedin.springboot_my_linkedin.service.RegistrationService;
import com.springboot.linkedin.springboot_my_linkedin.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillsController {

    @Autowired
    private SkillsService service;
}
