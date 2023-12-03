package com.mjudb.officeservice.repository;

import com.mjudb.officeservice.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByProjNum(Long proj_num);

    @Query("select p from Project p where p.proj_num in (select Project.proj_num from Project where Project.proj_start <= :date and Project.proj_end >= :date)")
    List<Project> findByDate(@Param("date") Long date);
}
