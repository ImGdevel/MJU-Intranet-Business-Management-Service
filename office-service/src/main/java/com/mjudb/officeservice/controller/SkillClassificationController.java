package com.mjudb.officeservice.controller;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.service.ProjectService;
import com.mjudb.officeservice.service.RoleService;
import com.mjudb.officeservice.service.SkillClassificationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/SkillClassification")
@Api(tags = {"기술 정보 API"})
public class SkillClassificationController {
    private final SkillClassificationService skillClassificationService;

    @Autowired
    public SkillClassificationController(SkillClassificationService skillClassificationService){
        this.skillClassificationService = skillClassificationService;
    }

    @GetMapping("/{skill_num}")
    public String findRoleByID(@PathVariable(name = "skill_num") Long skill_num){
        return skillClassificationService.findSkillByID(skill_num);
    }
}