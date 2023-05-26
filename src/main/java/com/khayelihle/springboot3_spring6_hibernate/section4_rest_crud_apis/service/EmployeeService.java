package com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.service;

import com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.entity.Employee;
import java.util.List;

public interface EmployeeService {
    //same methods as the DAO layer methods
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
