package com.mjudb.officeservice.service;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.domain.Schedule;
import com.mjudb.officeservice.repository.EmployeeRepository;
import com.mjudb.officeservice.repository.ProjectRepository;
import com.mjudb.officeservice.repository.RoleRepository;
import com.mjudb.officeservice.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> findByProj_num(Long proj_num){
        return scheduleRepository.findByProj_num(proj_num);
    }
}
