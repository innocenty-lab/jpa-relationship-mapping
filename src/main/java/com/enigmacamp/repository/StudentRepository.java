package com.enigmacamp.repository;

import com.enigmacamp.entity.Student;

import java.util.List;

public interface StudentRepository {
    void create(Student student);
    Student getById(int id);
    List<Student> getAll(int page, int pageSize);
    void delete(int id);
    void update(Student student);
}
