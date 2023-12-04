package com.mjudb.officeservice.service;

import com.mjudb.officeservice.domain.ParticipantNumber;
import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.repository.EmployeeRepository;
import com.mjudb.officeservice.repository.ParticipantNumberRepository;
import com.mjudb.officeservice.repository.ProjectRepository;
import com.mjudb.officeservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantNumberService {
    private final ParticipantNumberRepository participantNumberRepository;
    @Autowired
    public ParticipantNumberService(ParticipantNumberRepository participantNumberRepository){
        this.participantNumberRepository = participantNumberRepository;
    }

    public Long findNumByID(Long emp_num){
        return participantNumberRepository.findById(emp_num).get().getParticipant_num();
    }
}
