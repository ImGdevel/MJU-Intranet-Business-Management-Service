package com.mjudb.officeservice.repository;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.domain.ProjectParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Project, Long> {
    @Query("SELECT pp FROM ProjectParticipant pp JOIN FETCH Project p " +
            "WHERE pp.emp_num = :emp_num")
    List<ProjectParticipant> findParticipationByEmployeeNumber(@Param("emp_num") String emp_num);
}
