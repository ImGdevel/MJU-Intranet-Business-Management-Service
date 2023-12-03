package com.mjudb.officeservice.service;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.repository.EmployeeRepository;
import com.mjudb.officeservice.repository.ProjectRepository;
import com.mjudb.officeservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public String findRoleByID(Long role_num){
        return roleRepository.findById(role_num).get().getRole_name();
    }
}
