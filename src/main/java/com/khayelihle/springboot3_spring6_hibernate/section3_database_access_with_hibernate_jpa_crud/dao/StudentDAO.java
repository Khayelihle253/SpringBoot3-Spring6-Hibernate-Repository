package com.khayelihle.springboot3_spring6_hibernate.section3_database_access_with_hibernate_jpa_crud.dao;

import com.khayelihle.springboot3_spring6_hibernate.section3_database_access_with_hibernate_jpa_crud.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(int id);

    int deleteAll();

}
