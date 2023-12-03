package com.mjudb.officeservice.controller;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.domain.ProjectParticipant;
import com.mjudb.officeservice.service.ProjectParticipantService;
import com.mjudb.officeservice.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project-participant")
@Api(tags = {"프로젝트 참여 정보 API"})
public class ProjectParticipantController {
    private final ProjectParticipantService projectParticipantService;

    @Autowired
    public ProjectParticipantController(ProjectParticipantService projectParticipantService){
        this.projectParticipantService = projectParticipantService;
    }

    @GetMapping("/project/{proj_num}")
    @ApiOperation(value = "해당 프로젝트에 참여하는 직원들의 참여정보를 조회한다.")
    public List<ProjectParticipant> findByProj_num(@PathVariable(name = "proj_num") Long proj_num){
        return projectParticipantService.findByProj_num(proj_num);
    }

    @GetMapping("/emp/{emp_num}")
    @ApiOperation(value = "해당 직원이 참여한 프로젝트에 대한 참여정보를 조회한다.")
    public List<ProjectParticipant> findProjectParticipantByEmp_num(@PathVariable(name = "emp_num") Long emp_num){
        return projectParticipantService.findProjectParticipantByEmp_num(emp_num);
    }
}
