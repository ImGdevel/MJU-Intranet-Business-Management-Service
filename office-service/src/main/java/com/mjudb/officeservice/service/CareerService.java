package com.mjudb.officeservice.service;

import com.mjudb.officeservice.domain.Career;
import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.domain.Skill;
import com.mjudb.officeservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerService {
    private final CareerRepository careerRepository;
    @Autowired
    public CareerService(CareerRepository careerRepository){
        this.careerRepository = careerRepository;
    }

    public List<Career> findByEmp_num(Long emp_num){
        return careerRepository.findByEmp_num(emp_num);
    }
}
