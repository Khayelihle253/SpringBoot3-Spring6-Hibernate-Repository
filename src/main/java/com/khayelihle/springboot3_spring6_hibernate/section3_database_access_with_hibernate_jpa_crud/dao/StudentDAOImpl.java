package com.khayelihle.springboot3_spring6_hibernate.section3_database_access_with_hibernate_jpa_crud.dao;

import com.khayelihle.springboot3_spring6_hibernate.section3_database_access_with_hibernate_jpa_crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Repository annotation will give us support for commponent scanning and
 * translates JDBC exceptions.
 */
@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * - implement the save method
     * - use the @Transactional annotation since we are performing an update on the database
     * @param theStudent
     */
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
