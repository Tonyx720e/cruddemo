package com.jpa.cruddemo.entity;

import java.util.List;

public interface StudentDAO {
    void save(Student theEstudent);

    Student findById(Integer id);

    List<Student> findAll();
    
    Student findByNamStudent(String nombre);
}

