package com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.dao;

import com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define the entity manager
    private EntityManager entityManager;

    //entity manager constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute the query and get results
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        //Employee
        Employee employee = entityManager.find(Employee.class, id);

        //return the results
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        /* save employee and return it...if id==0 (employee doesn't exist on the database)
            - an insert/save will be performed, otherwise it will perform an update
         */
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        //employee to be deleted
        Employee employee = entityManager.find(Employee.class, id);

        //remove/delete the employee
        entityManager.remove(employee);
    }
}
