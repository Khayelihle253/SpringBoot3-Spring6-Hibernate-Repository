package com.khayelihle.springboot3_spring6_hibernate.section5_rest_api_security_using_spring_data_jpa.service;

import com.khayelihle.springboot3_spring6_hibernate.section5_rest_api_security_using_spring_data_jpa.entity.Employee1;
import java.util.List;

public interface EmployeeService1 {

    List<Employee1> findAll();

    Employee1 findById(int theId);

    Employee1 save(Employee1 theEmployee);

    void deleteById(int theId);

}
