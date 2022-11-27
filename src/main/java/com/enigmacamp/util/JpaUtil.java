package com.enigmacamp.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory entityManagerFactory;

    public static void getEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        System.out.println(entityManagerFactory);
    }

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            getEntityManagerFactory();
        }
        return entityManagerFactory.createEntityManager();
    }

    public static void shutDown() {
        if (entityManagerFactory != null) {
            getEntityManager().close();
        }
    }
}
