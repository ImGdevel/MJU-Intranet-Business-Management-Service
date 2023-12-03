package com.mjudb.officeservice.repository;

import com.mjudb.officeservice.domain.*;
import com.mjudb.officeservice.service.CareerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CareerRepository extends JpaRepository<Career, CareerID> {
    @Query("select c from Career c where c.emp_num = :emp_num")
    List<Career> findByEmp_num(@Param("emp_num")Long emp_num);
}