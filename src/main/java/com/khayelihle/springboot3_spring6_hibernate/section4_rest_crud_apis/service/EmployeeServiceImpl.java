package com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.service;

import com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.dao.EmployeeDAO;
import com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    //employee dao
    private EmployeeDAO employeeDAO;

    //constructor injection on the employee dao
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
