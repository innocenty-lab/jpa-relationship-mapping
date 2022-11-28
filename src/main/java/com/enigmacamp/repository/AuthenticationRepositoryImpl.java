package com.enigmacamp.repository;

import com.enigmacamp.entity.Student;
import com.enigmacamp.entity.UserCredential;
import jakarta.persistence.EntityManager;

public class AuthenticationRepositoryImpl implements AuthenticationRepository {
    private EntityManager entityManager;

    public AuthenticationRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(UserCredential userCredential) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userCredential);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    @Override
    public UserCredential getById(String id) {
        return entityManager.find(UserCredential.class, id);
    }
}
