package com.mjudb.officeservice.service;

import com.mjudb.officeservice.domain.Customer;
import com.mjudb.officeservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public String findCustomerbyid(Long cus_id){
        return customerRepository.findById(cus_id).get().getCust_name();
    }
}
