package com.khayelihle.springboot3_spring6_hibernate.section5_rest_api_security_using_spring_data_jpa.rest;

import com.khayelihle.springboot3_spring6_hibernate.section5_rest_api_security_using_spring_data_jpa.entity.Employee1;
import com.khayelihle.springboot3_spring6_hibernate.section5_rest_api_security_using_spring_data_jpa.service.EmployeeService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1")
public class EmployeeRestController1 {

    private EmployeeService1 employeeService;

    @Autowired
    public EmployeeRestController1(EmployeeService1 theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee1> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee1 getEmployee(@PathVariable int employeeId) {

        Employee1 theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/employees")
    public Employee1 addEmployee(@RequestBody Employee1 theEmployee) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee1 dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public Employee1 updateEmployee(@RequestBody Employee1 theEmployee) {

        Employee1 dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee1 tempEmployee = employeeService.findById(employeeId);

        // throw exception if null

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

}














