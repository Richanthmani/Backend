package com.springboot.linkedin.springboot_my_linkedin.controller;

import com.springboot.linkedin.springboot_my_linkedin.model.Profile;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import com.springboot.linkedin.springboot_my_linkedin.service.ProfileService;
import com.springboot.linkedin.springboot_my_linkedin.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

  @Autowired
  private RegistrationService service;

    @Autowired
    private ProfileService pservice;
  @PostMapping("/registeruser")
  @CrossOrigin(origins = "http://localhost:4200")
  public User registerUser(@RequestBody User user) throws Exception{

    User userObj = null;

    service.userExists(user);
    userObj=service.saveUser(user);
    return userObj;

  }
  @PostMapping("/login")
  @CrossOrigin(origins = "http://localhost:4200")
  public User loginUser(@RequestBody User user) throws Exception{
      User userObj=null;
      userObj=service.correctUser(user);
      return userObj;
  }
}
