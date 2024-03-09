package com.example.demohibernate.Service;

import com.example.demohibernate.Model.Color;
import com.example.demohibernate.Util.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ColorService {
    private final EntityManager em = JPAUtils.getEntityManager();

    public List<Color> getAllColor(){
        TypedQuery<Color> color = this.em.createQuery("SELECT cl FROM Color cl", Color.class);
        return color.getResultList();
    }
}
