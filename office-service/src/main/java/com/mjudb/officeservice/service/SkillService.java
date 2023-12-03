package com.mjudb.officeservice.service;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.domain.Skill;
import com.mjudb.officeservice.repository.EmployeeRepository;
import com.mjudb.officeservice.repository.ProjectRepository;
import com.mjudb.officeservice.repository.RoleRepository;
import com.mjudb.officeservice.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    private final SkillRepository skillRepository;
    @Autowired
    public SkillService(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }

    public List<Skill> findSkillByEmp_num(Long emp_num){
        return skillRepository.findByEmp_num(emp_num);
    }
}
