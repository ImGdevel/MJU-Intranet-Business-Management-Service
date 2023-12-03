package com.mjudb.officeservice.service;

import com.mjudb.officeservice.domain.Employee;
import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.repository.EmployeeRepository;
import com.mjudb.officeservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee findEmployeeByID(Long emp_num){
        return employeeRepository.findById(emp_num).get();
    }
}
