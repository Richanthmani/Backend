package com.springboot.linkedin.springboot_my_linkedin.controller;

import com.springboot.linkedin.springboot_my_linkedin.model.User;
import com.springboot.linkedin.springboot_my_linkedin.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

  @Autowired
  private RegistrationService service;
  @PostMapping("/registeruser")
  @CrossOrigin(origins = "http://localhost:4200")
  public User registerUser(@RequestBody User user) throws Exception{
    String tempEmailId=user.getEmailId();
    if(tempEmailId!=null && !"".equals(tempEmailId)){
       User userObj= service.fetchUserByEmailId(tempEmailId);
       if(userObj!=null){
         throw new Exception("user with this"+ tempEmailId + "is already exists");
       }
    }
    User userObj = null;
    userObj=service.saveUser(user);
    return userObj;

  }
  @PostMapping("/login")
  @CrossOrigin(origins = "http://localhost:4200")
  public User loginUser(@RequestBody User user) throws Exception{
      String tempEmailId=user.getEmailId();
      String tempPass=user.getPassword();
      User userObj=null;
      if(tempEmailId !=null && tempPass !=null){
          userObj=service.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);

      }
      if(userObj==null){
          throw new Exception("Bad credentials");
      }
      return userObj;
  }
}
