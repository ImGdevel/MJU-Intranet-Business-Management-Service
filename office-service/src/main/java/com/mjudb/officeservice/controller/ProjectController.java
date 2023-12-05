package com.mjudb.officeservice.controller;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project")
@Api(tags = {"프로젝트 정보 API"})
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/{date}")
    @ApiOperation(value = "날짜에 진행중인 프로젝트를 검색한다.")
    public List<Project> findByDate(@PathVariable(name = "date") String date){
        return projectService.findByDate(date);
    }
    @GetMapping("/period/{start}/{end}")
    @ApiOperation(value = "해당 기간내에 진행중인 프로젝트를 검색한다.")
    public List<Project> findByPeriod(@PathVariable(name = "start") String start, @PathVariable(name = "end") String end){
        return projectService.findByPeriod(start, end);
    }


    @GetMapping("/detail/{proj-id}")
    @ApiOperation(value = "프로젝트 정보를 검색한다.")
    public Project findByID(@PathVariable(name = "proj-id") Long id){
        return projectService.findProjectbyID(id);
    }

    @GetMapping("/name/{proj-id}")
    @ApiOperation(value = "프로젝트 이름을 반환한다.")
    public String findProjectName(@PathVariable(name = "proj-id") Long id){
        return projectService.findProjectName(id);
    }
}
