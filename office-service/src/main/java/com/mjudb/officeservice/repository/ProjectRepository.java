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
            "JOIN ParticipantNumber pn ON p.proj_num = pn.proj_num\n"+
            "WHERE p.proj_start <= :date AND p.proj_end >= :date\n")
    List<Project> findByDate(@Param("date") String date);

    @Query("SELECT p\n" +
            "FROM Project p\n" +
            "WHERE (:start BETWEEN p.proj_start AND p.proj_end)\n" +
            "    OR (:end BETWEEN p.proj_start AND p.proj_end)\n" +
            "OR (p.proj_start BETWEEN :start AND :end)")
    List<Project> findByPeriod(@Param("start") String start, @Param("end") String end);

    Optional<Project> findById(Long id);

}
