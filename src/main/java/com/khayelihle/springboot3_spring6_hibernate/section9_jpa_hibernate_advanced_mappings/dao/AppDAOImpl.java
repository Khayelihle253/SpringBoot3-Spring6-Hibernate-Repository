package com.khayelihle.springboot3_spring6_hibernate.section9_jpa_hibernate_advanced_mappings.dao;

import com.khayelihle.springboot3_spring6_hibernate.section9_jpa_hibernate_advanced_mappings.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {

        Instructor instructor = entityManager.find(Instructor.class,id);
        if (instructor == null){
            throw new RuntimeException("Couldn't find the a record with id: " + id);
        }

        return instructor;
    }

    @Override
    @Transactional
    public String delete(int id) {

        Instructor instructor = this.findById(id);
        if (instructor == null){
            return "Couldn't perform the delete because id: " + id + " doesn't exist";
        }
        entityManager.remove(instructor);
        return "Successfully deleted the record with id " + id;
    }
}
