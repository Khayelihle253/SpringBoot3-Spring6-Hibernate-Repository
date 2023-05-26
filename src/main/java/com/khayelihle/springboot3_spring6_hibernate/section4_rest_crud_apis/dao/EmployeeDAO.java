package com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.dao;

import com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
