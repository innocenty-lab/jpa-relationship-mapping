package com.enigmacamp.repository;

import com.enigmacamp.entity.Major;
import jakarta.persistence.EntityManager;

public class MajorRepositoryImpl implements MajorRepository {
    private final EntityManager entityManager;

    public MajorRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Major major) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(major);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    @Override
    public Major findOne(long id) {
        return entityManager.find(Major.class, id);
    }
}
