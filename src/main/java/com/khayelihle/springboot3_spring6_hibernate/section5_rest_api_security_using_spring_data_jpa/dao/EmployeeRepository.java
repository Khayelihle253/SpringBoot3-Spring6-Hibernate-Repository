package com.khayelihle.springboot3_spring6_hibernate.section5_rest_api_security_using_spring_data_jpa.dao;

import com.khayelihle.springboot3_spring6_hibernate.section5_rest_api_security_using_spring_data_jpa.entity.Employee1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee1, Integer> {

    // that's it ... no need to write any code LOL!

    //add a method to sort by last name
    public List<Employee1> findAllByOrderByLastNameAsc();

}
