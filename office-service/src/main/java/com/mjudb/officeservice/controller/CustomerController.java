package com.mjudb.officeservice.controller;

import com.mjudb.officeservice.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/customer")
@Api(tags = {"발주처 정보 API"})
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController (CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/{cus-id}")
    @ApiOperation(value = "발주처 이름을 반환한다.")
    public String findCustomerName(@PathVariable(name = "cus-id") Long id){
        return customerService.findCustomerbyid(id);
    }
}
