package com.mjudb.officeservice.repository;

import com.mjudb.officeservice.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Project, Long> {
    @Query("select s from Schedule s, (select pp.emp_num from ProjectParticipant pp where pp.proj_num = :proj_num) p where s.emp_num = p.emp_num and (s.sche_start_date >= :proj_start and s.sche_start_date <= :proj_end) or (s.sche_end_date >= :proj_start and s.sche_end_date <= :proj_end)")
    List<Project> findByDate(@Param("proj_um") Long proj_num, @Param("proj_start") String proj_start, @Param("proj_end") String proj_end);
}
