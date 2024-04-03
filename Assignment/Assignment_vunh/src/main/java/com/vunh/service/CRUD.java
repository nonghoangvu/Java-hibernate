package com.vunh.service;

import com.vunh.utils.JPAUtil;

import java.util.List;

public abstract class CRUD<T> extends JPAUtil {
    public abstract List<T> findAll();

    public abstract T findById(int id);

    public Boolean save(T object) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(object);
            this.em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            return false;
        }
    }

    public Boolean update(T object){
        try {
            this.em.getTransaction().begin();
            this.em.merge(object);
            this.em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            return false;
        }
    }

    public Boolean delete(T object) {
        try {
            this.em.getTransaction().begin();
            this.em.remove(object);
            this.em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            this.em.getTransaction().rollback();
            return false;
        }
    }
}
