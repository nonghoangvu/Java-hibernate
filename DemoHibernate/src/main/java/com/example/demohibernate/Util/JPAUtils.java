package com.example.demohibernate.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtils {
    private static EntityManagerFactory factory;
    static public EntityManager getEntityManager() {
        if(factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory("Demo");
        }

        return factory.createEntityManager();
    }

    static public void shutdown() {
        if(factory != null || factory.isOpen()) {
            factory.close();
        }
        factory = null;
    }
}
