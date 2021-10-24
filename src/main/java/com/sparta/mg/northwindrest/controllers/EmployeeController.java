package com.sparta.mg.northwindrest.controllers;

import com.sparta.mg.northwindrest.entities.EmployeeEntity;
import com.sparta.mg.northwindrest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = "/employees")
    @ResponseBody
    public List<EmployeeEntity> getEmployees(@RequestParam (required = false) @PathVariable Integer id,
                                             @RequestParam (required = false) @PathVariable String name) {
        if(id != null){
            return employeeRepository.findById(id).stream().toList();
        }
        if(name != null){
            List<EmployeeEntity> foundEmployees = new ArrayList<>();
            for(EmployeeEntity employeeEntity: employeeRepository.findAll()){
                if(employeeEntity.getFirstName().toLowerCase().contains(name.toLowerCase())){
                    foundEmployees.add(employeeEntity);
                }
            }
            return foundEmployees;
        }
        else return employeeRepository.findAll();
    }
}
