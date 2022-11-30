package com.enigmacamp.repository;

import com.enigmacamp.entity.GroupProject;
import jakarta.persistence.EntityManager;

public class GroupProjectRepositoryImpl implements GroupProjectRepository {
    private final EntityManager entityManager;

    public GroupProjectRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(GroupProject groupProject) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(groupProject);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public GroupProject findOne(long id) {
        return entityManager.find(GroupProject.class, id);
    }
}
