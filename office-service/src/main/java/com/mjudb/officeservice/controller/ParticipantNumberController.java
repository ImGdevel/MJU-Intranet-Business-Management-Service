package com.mjudb.officeservice.controller;

import com.mjudb.officeservice.domain.Project;
import com.mjudb.officeservice.service.ParticipantNumberService;
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
@RequestMapping("/ParticipantNum")
@Api(tags = {"프로젝트 참여자수 API"})
public class ParticipantNumberController {
    private final ParticipantNumberService participantNumberService;

    @Autowired
    public ParticipantNumberController(ParticipantNumberService participantNumberService){
        this.participantNumberService = participantNumberService;
    }

    @GetMapping("/{proj_num}")
    public Long findNumByID(@PathVariable(name = "proj_num") Long proj_num){
        return participantNumberService.findNumByID(proj_num);
    }


}
