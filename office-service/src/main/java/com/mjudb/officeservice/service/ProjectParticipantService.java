package com.mjudb.officeservice.service;

import com.mjudb.officeservice.domain.ProjectParticipant;
import com.mjudb.officeservice.repository.ProjectParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectParticipantService {
    private final ProjectParticipantRepository projectParticipantRepository;
    @Autowired
    public ProjectParticipantService(ProjectParticipantRepository projectParticipantRepository){
        this.projectParticipantRepository = projectParticipantRepository;
    }

    public List<ProjectParticipant> findByProj_num(Long proj_num){
        return projectParticipantRepository.findByProj_num(proj_num);
    }

    public List<ProjectParticipant> findProjectParticipantByEmp_num(Long emp_num){
        return projectParticipantRepository.findByEmp_num(emp_num);
    }
}
