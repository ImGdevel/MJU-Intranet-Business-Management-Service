package com.mjudb.officeservice.repository;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Project, Long> {
    @Query("SELECT s FROM Schedule s\n" +
            "WHERE s.emp_num IN (SELECT pp.emp_num FROM ProjectParticipant pp WHERE pp.proj_num = :proj_num)\n" +
            "AND (\n" +
            "    (s.sche_start_date >= :proj_start AND s.sche_start_date <= :proj_end)\n" +
            "    OR (s.sche_end_date >= :proj_start AND s.sche_end_date <= :proj_end)\n)")
    List<Schedule> findByDate(@Param("proj_num") Long proj_num, @Param("proj_start") String proj_start, @Param("proj_end") String proj_end);
}
