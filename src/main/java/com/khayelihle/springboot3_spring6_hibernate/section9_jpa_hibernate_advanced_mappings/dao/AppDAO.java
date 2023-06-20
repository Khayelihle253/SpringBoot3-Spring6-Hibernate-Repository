package com.khayelihle.springboot3_spring6_hibernate.section9_jpa_hibernate_advanced_mappings.dao;

import com.khayelihle.springboot3_spring6_hibernate.section9_jpa_hibernate_advanced_mappings.entity.Instructor;
import jakarta.persistence.EntityManager;

public interface AppDAO {

    void save(Instructor instructor);
}
