package com.mjudb.officeservice.controller;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.service.EmployeeService;
import com.mjudb.officeservice.service.ProjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Api(tags = {"직원 이름을 반환한다."})
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/{emp_num}")
    public String findEmployeeByID(@PathVariable(name = "emp_num") Long emp_num){
        return employeeService.findEmployeeByID(emp_num);
    }

}
