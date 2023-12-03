package com.mjudb.officeservice.controller;

import com.mjudb.officeservice.domain.Career;
import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.domain.Skill;
import com.mjudb.officeservice.service.CareerService;
import com.mjudb.officeservice.service.ProjectService;
import com.mjudb.officeservice.service.RoleService;
import com.mjudb.officeservice.service.SkillService;
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
@RequestMapping("/Career")
@Api(tags = {"직원 경력 API"})
public class CareerController {
    private final CareerService careerService;

    @Autowired
    public CareerController(CareerService careerService){
        this.careerService = careerService;
    }

    @GetMapping("/{emp_num}")
    @ApiOperation(value = "해당 직원이 보유한 기술 정보를 조회한다.")
    public List<Career> findByEmp_num(@PathVariable(name = "emp_num") Long emp_num){
        return careerService.findByEmp_num(emp_num);
    }


}
