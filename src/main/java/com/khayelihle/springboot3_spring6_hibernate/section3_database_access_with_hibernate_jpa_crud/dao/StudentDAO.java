package com.khayelihle.springboot3_spring6_hibernate.section3_database_access_with_hibernate_jpa_crud.dao;

import com.khayelihle.springboot3_spring6_hibernate.section3_database_access_with_hibernate_jpa_crud.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

}
