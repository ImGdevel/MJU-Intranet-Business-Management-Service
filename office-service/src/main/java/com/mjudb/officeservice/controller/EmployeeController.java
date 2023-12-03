package com.mjudb.officeservice.controller;

import com.mjudb.officeservice.domain.Employee;
import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.service.EmployeeService;
import com.mjudb.officeservice.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employee")
@Api(tags = {"직원 정보 API"})
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/{emp_num}")
    @ApiOperation(value = "직원 정보를 반환한다.")
    public Employee findEmployeeByID(@PathVariable(name = "emp_num") Long emp_num){
        return employeeService.findEmployeeByID(emp_num);
    }

    @GetMapping("/name/{emp_num}")
    @ApiOperation(value = "직원 이름을 반환한다.")
    public String findEmployeeName(@PathVariable(name = "emp_num") Long emp_num) {
        return employeeService.findEmployeeName(emp_num);
    }
}
