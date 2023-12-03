package com.mjudb.officeservice.repository;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.domain.ProjectParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectParticipantRepository extends JpaRepository<Project, Long> {
    @Query("select pp from ProjectParticipant pp where pp.proj_num = :proj_num")
    List<ProjectParticipant> findByProjNum(@Param("proj_num") Long proj_num);
}
