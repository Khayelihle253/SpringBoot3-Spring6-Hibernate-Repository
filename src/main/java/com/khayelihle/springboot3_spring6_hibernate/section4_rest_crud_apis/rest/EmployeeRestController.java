package com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.rest;

import com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.entity.Employee;
import com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //employee service
    private EmployeeService employeeService;

    //inject the employee service layer
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //expose the endpoints
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
