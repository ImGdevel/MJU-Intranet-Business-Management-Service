package com.mjudb.officeservice.repository;

import com.mjudb.officeservice.domain.ProjectParticipant;
import com.mjudb.officeservice.domain.ProjectParticipantID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectParticipantRepository extends JpaRepository<ProjectParticipant, ProjectParticipantID> {
    @Query("select pp from ProjectParticipant pp where pp.proj_num = :proj_num")
    List<ProjectParticipant> findByProj_num(@Param("proj_num") Long proj_num);

    @Query("SELECT pp FROM ProjectParticipant pp " +
            "WHERE pp.emp_num = :emp_num")
    List<ProjectParticipant> findByEmp_num(@Param("emp_num") Long emp_num);
}
