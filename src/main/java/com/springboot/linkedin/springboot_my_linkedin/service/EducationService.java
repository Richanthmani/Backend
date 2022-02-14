package com.springboot.linkedin.springboot_my_linkedin.service;

import com.springboot.linkedin.springboot_my_linkedin.model.Education;
import com.springboot.linkedin.springboot_my_linkedin.model.Skills;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import com.springboot.linkedin.springboot_my_linkedin.repository.EducationRepository;
import com.springboot.linkedin.springboot_my_linkedin.repository.RegistrationRepository;
import com.springboot.linkedin.springboot_my_linkedin.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EducationService {


    @Autowired
    private EducationRepository erepo;
    @Autowired
    private RegistrationRepository repo;



    public Education saveEducation(Education education,int userId) {
        return erepo.save(new Education(education.getInstitution(),
                education.getDegree(),
                education.getMajor(),
                education.getLocation(),
                education.getScore(),
                education.getEndDate(),
                education.getStartDate()
                ,repo.findById(userId)));

    }

    public List<Education> fetchEducationByuserId(User userId){

        return erepo.findByUserId(userId);
    }

    public List<Education> fetchEducationByIdAfterDeletion(int id,int userId){

        erepo.deleteById(id);
        return erepo.findByUserId(repo.findById(userId));
    }
}

