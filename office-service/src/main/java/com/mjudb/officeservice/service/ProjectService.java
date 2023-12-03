package com.mjudb.officeservice.service;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> findByDate(String date){
        return projectRepository.findByDate(date);
    }

    public Project findProjectbyID(Long id){
        return projectRepository.findById(id).get();
    }

    public String findProjectName(Long id){
        return projectRepository.findById(id).get().getProj_name();
    }
}
