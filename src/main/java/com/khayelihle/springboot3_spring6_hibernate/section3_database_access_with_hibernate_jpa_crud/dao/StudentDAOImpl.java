package com.khayelihle.springboot3_spring6_hibernate.section3_database_access_with_hibernate_jpa_crud.dao;

import com.khayelihle.springboot3_spring6_hibernate.section3_database_access_with_hibernate_jpa_crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Repository annotation will give us support for component scanning and
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

    /**
     * No need to use @Transactional here because we are querying data, not doing any modifications to the database
     * @param id
     * @return
     */
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    /**
     * Find all students (list) from the database using JPQL
     * @return
     */
    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create the query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student where lastName=:theData", Student.class);

        //set query parameters
        theQuery.setParameter("theData",lastName);

        //return the results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        //update the student
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        //retrieve student
        Student student = entityManager.find(Student.class,id);

        //delete student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("Delete from Student").executeUpdate();
        return numRowsDeleted;
    }
}
