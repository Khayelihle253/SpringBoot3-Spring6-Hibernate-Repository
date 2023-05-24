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
}
