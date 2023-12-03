package com.mjudb.officeservice.service;

import com.mjudb.officeservice.repository.SkillClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillClassificationService {
    private final SkillClassificationRepository skillClassificationRepository;
    @Autowired
    public SkillClassificationService(SkillClassificationRepository skillClassificationRepository){
        this.skillClassificationRepository = skillClassificationRepository;
    }

    public String findSkillByID(Long skill_num){
        return skillClassificationRepository.findById(skill_num).get().getSkill_name();
    }
}
