package com.mjudb.officeservice.controller;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.domain.Schedule;
import com.mjudb.officeservice.domain.Skill;
import com.mjudb.officeservice.service.ProjectService;
import com.mjudb.officeservice.service.RoleService;
import com.mjudb.officeservice.service.ScheduleService;
import com.mjudb.officeservice.service.SkillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Skhedule")
@Api(tags = {"직원 일정 API"})
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{proj_num}")
    @ApiOperation(value = "해당 프로젝트 참여자 중에 프로젝트 기간동안 일정이 있는 직원들의 일정을 조회한다.")
    public List<Schedule> findByEmp_num(@PathVariable(name = "proj_num") Long proj_num){
        return scheduleService.findByProj_num(proj_num);
    }


}
