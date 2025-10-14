package com.jpa.cruddemo.entity;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        this.entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id){
        return this.entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
       TypedQuery<Student> theQuery;
       theQuery = entityManager.createQuery("FROM Student", Student.class);
         return theQuery.getResultList();
    }

    

    

    
}
