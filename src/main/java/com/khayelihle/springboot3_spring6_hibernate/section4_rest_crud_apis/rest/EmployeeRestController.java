package com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.rest;

import com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.entity.Employee;
import com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if (employee == null){
            throw new RuntimeException("Employee could not be found - id:" + id);
        }
        return employee;
    }

    @PostMapping("/employees")
    Employee save(@RequestBody Employee employee){

        //the employee id should be 0 to save a new item instead of updating an existing employee
        if (!(employee.getId() == 0)){
            employee.setId(0);
        }

//        //save employee
//        Employee theEmployee = employeeService.save(employee);
//
//        //return the saved employee
//        return theEmployee;
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    Employee updateEmployee(@RequestBody Employee employee){
        //id of the employee to be updated must be specified
        if (employee.getId() == 0){
            throw new RuntimeException("Please enter the id of the employee to be updated");
        }
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public  String deleteEmployee(@PathVariable int id){
        //find the employee by id
        Employee employee = employeeService.findById(id);

        //throw an exception if null
        if (employee == null){
            throw new RuntimeException("Employee could not be found - id:" + id);
        }

        //delete employee
        employeeService.deleteById(id);

        return "Successfully deleted an employee with id: " + id;
    }
}
