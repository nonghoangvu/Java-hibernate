package com.vunh.hibernateclass.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory factory;
    public EntityManager em = getEntityManager();

    public static EntityManager getEntityManager() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory("java4");
        }
        return factory.createEntityManager();
    }

    public static void shutdown() {
        if (factory != null || factory.isOpen()) {
            factory.close();
        }
        factory = null;
    }
}