package com.vunh.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory factory;
    public EntityManager em = getEntityManager();

    public static EntityManager getEntityManager() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory("vu-pro");
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
//DateTimeConverter dtc = new DataConverter(new Date());
//dtc.setPattern("MM/dd/yyyy");
//ConvertUtils.register(dtc, Date.class);