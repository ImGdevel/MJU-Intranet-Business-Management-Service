package com.mjudb.officeservice.repository;

import com.mjudb.officeservice.domain.Schedule;
import com.mjudb.officeservice.domain.ScheduleID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, ScheduleID> {
}
