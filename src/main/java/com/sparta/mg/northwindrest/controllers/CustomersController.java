package com.sparta.mg.northwindrest.controllers;

import com.sparta.mg.northwindrest.entities.CustomerEntity;
import com.sparta.mg.northwindrest.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomersController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomersController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<CustomerEntity> getAllCustomers(@RequestParam(required = false) String name) {
        if (name == null) {
            return customerRepository.findAll();
        }

        List<CustomerEntity> foundCustomers = new ArrayList<>();
        for(CustomerEntity customerEntity: customerRepository.findAll()){
            if(customerEntity.getContactName().contains(name)){
                foundCustomers.add(customerEntity);
            }
        }
        return foundCustomers;
    }
}
