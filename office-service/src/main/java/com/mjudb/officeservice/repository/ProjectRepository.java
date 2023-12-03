package com.mjudb.officeservice.repository;

import com.mjudb.officeservice.domain.Project;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p\n" +
            "FROM Project p\n" +
            "JOIN Project subProj\n" +
            "    ON p.proj_num = subProj.proj_num\n" +
            "WHERE subProj.proj_start <= :date AND subProj.proj_end >= :date")
    List<Project> findByDate(@Param("date") String date);

    Optional<Project> findById(Long id);
}
