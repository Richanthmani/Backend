package com.springboot.linkedin.springboot_my_linkedin.service;

import com.springboot.linkedin.springboot_my_linkedin.model.Profile;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import com.springboot.linkedin.springboot_my_linkedin.repository.ProfileRepository;
import com.springboot.linkedin.springboot_my_linkedin.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repo;
    @Autowired
    private ProfileRepository prepo;
    public User saveUser(User user){
       User newUser = repo.save(user);
        prepo.save(new Profile(user.getUserName(),user.getEmailId(),newUser));
         return newUser;

    }
    public User userExists(User user) throws Exception {
        String tempEmailId = user.getEmailId();
        User userObj = null;
        if (tempEmailId != null && !"".equals(tempEmailId)) {
            userObj = this.fetchUserByEmailId(tempEmailId);
            if (userObj != null) {
                throw new Exception("user with this " + tempEmailId + " is already exists");
            }
        }
        return userObj;
    }
    public User correctUser(User user) throws Exception{
        String tempEmailId=user.getEmailId();
        String tempPass=user.getPassword();
        User userObj=null;
        if(tempEmailId !=null && tempPass !=null){
            userObj=this.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);

        }
        if(userObj==null){
            throw new Exception("Bad credentials");
        }
        return userObj;
    }
    public User fetchUserByEmailId(String email){
         return repo.findByEmailId(email);
    }
    public User fetchUserByEmailIdAndPassword(String email,String password){
        return repo.findByEmailIdAndPassword(email,password);
    }
}
