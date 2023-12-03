package com.mjudb.officeservice.repository;

import com.mjudb.officeservice.domain.Skill;
import com.mjudb.officeservice.domain.SkillClassification;
import com.mjudb.officeservice.domain.SkillID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, SkillID> {
    @Query("select s from Skill s where s.emp_num = :emp_num")
    List<Skill> findByEmp_num(@Param("emp_num")Long emp_num);
}
