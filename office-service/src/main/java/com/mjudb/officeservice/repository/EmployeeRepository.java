package com.mjudb.officeservice.repository;

import com.mjudb.officeservice.domain.Employee;
import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.domain.ProjectParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Override
//    Optional<Employee> findById(Long emp_num);
}