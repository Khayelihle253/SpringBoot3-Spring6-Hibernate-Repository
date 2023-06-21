package com.khayelihle.springboot3_spring6_hibernate.section9_jpa_hibernate_advanced_mappings.dao;

import com.khayelihle.springboot3_spring6_hibernate.section9_jpa_hibernate_advanced_mappings.entity.Instructor;
import com.khayelihle.springboot3_spring6_hibernate.section9_jpa_hibernate_advanced_mappings.entity.InstructorDetail;
import jakarta.persistence.EntityManager;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(int id);

    String delete(int id);

    InstructorDetail findInstructorDetailById(int id);
}
