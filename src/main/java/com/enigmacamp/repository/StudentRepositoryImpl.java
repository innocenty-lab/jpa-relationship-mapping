package com.enigmacamp.repository;

import com.enigmacamp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private EntityManager entityManager;

    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Student student) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    @Override
    public Student getById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAll(int page, int pageSize) {
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery("Select s FROM Student s", Student.class);
        studentTypedQuery.setFirstResult((page - 1) * pageSize);
        studentTypedQuery.setMaxResults(pageSize);
        return studentTypedQuery.getResultList();
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }

    @Override
    public void update(Student student) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
