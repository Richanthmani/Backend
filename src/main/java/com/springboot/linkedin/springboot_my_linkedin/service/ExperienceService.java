package com.springboot.linkedin.springboot_my_linkedin.service;

import com.springboot.linkedin.springboot_my_linkedin.model.Education;
import com.springboot.linkedin.springboot_my_linkedin.model.Experience;
import com.springboot.linkedin.springboot_my_linkedin.model.User;
import com.springboot.linkedin.springboot_my_linkedin.repository.EducationRepository;
import com.springboot.linkedin.springboot_my_linkedin.repository.ExperienceRepository;
import com.springboot.linkedin.springboot_my_linkedin.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository exrepo;
    @Autowired
    private RegistrationRepository repo;



    public Experience saveExperience(Experience experience, int userId) {
        return exrepo.save(new Experience(experience.getCompany(),
                experience.getRole(),
                experience.getLocation(),
                experience.getEndDate(),
                experience.getStartDate()
                ,repo.findById(userId)));

    }

    public List<Experience> fetchExperienceByuserId(User userId){

        return exrepo.findByUserId(userId);
    }

    public List<Experience> fetchExperienceByIdAfterDeletion(int id,int userId){

        exrepo.deleteById(id);
        return exrepo.findByUserId(repo.findById(userId));
    }
}
