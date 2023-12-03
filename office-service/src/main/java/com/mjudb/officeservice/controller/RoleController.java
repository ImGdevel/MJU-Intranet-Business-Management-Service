package com.mjudb.officeservice.controller;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.service.ProjectService;
import com.mjudb.officeservice.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Role")
@Api(tags = {"직무 정보 API"})
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping("/{role_num}")
    public String findRoleByID(@PathVariable(name = "role_num") Long role_num){
        return roleService.findRoleByID(role_num);
    }


}
