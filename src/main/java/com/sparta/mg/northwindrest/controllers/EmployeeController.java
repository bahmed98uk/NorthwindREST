package com.sparta.mg.northwindrest.controllers;

import com.sparta.mg.northwindrest.entities.EmployeeEntity;
import com.sparta.mg.northwindrest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    @ResponseBody
    public Optional getEmployeesByName(@PathVariable Integer id) {
        return employeeRepository.findById(id);
    }
}
