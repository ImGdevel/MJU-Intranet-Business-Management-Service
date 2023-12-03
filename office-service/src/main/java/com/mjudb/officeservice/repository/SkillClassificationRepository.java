package com.mjudb.officeservice.repository;

import com.mjudb.officeservice.domain.Skill;
import com.mjudb.officeservice.domain.SkillClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillClassificationRepository extends JpaRepository<SkillClassification, Long> {

}
