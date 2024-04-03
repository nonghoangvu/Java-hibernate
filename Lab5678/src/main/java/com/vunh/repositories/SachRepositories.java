package com.vunh.repositories;

import com.vunh.entities.Sach;
import com.vunh.utils.JPAUtil;

import java.util.List;

public class SachRepositories extends JPAUtil {
    public List<Sach> findAll(){
        return this.em.createQuery("FROM Sach ", Sach.class).getResultList();
    }

    public Boolean save(Sach sach){
        try {
            this.em.getTransaction().begin();
            this.em.persist(sach);
            this.em.getTransaction().commit();
            return true;
        }catch (Exception e){
            this.em.getTransaction().rollback();
            return false;
        }
    }
    public Boolean delete(Sach sach){
        try {
            this.em.getTransaction().begin();
            this.em.remove(sach);
            this.em.getTransaction().commit();
            return true;
        }catch (Exception e){
            this.em.getTransaction().rollback();
            return false;
        }
    }
    public Sach findByID(Integer id){
        return this.em.find(Sach.class, id);
    }
}
