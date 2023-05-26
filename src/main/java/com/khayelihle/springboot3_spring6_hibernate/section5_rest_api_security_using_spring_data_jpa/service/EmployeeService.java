package com.khayelihle.springboot3_spring6_hibernate.section5_rest_api_security_using_spring_data_jpa.service;

import com.khayelihle.springboot3_spring6_hibernate.section5_rest_api_security_using_spring_data_jpa.entity.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
