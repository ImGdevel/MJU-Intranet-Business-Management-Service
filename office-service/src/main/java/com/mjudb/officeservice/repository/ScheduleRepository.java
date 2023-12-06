package com.mjudb.officeservice.repository;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.domain.Schedule;
import com.mjudb.officeservice.domain.ScheduleID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, ScheduleID> {
    @Query("SELECT s FROM Schedule s JOIN Project p ON p.proj_num = :proj_num " +
            "WHERE s.emp_num IN (SELECT pp.emp_num FROM ProjectParticipant pp WHERE pp.proj_num = :proj_num) " +
            "AND (s.sche_start_date BETWEEN p.proj_start AND p.proj_end " +
            "OR s.sche_end_date BETWEEN p.proj_start AND p.proj_end)")
    List<Schedule> findByProj_num(@Param("proj_num") Long proj_num);
}
