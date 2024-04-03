package com.vunh.hibernateclass.reponsitories;

import com.vunh.hibernateclass.entities.Size;
import com.vunh.hibernateclass.utils.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SizeResp extends JPAUtil {

    public List<Size> findAll() {
        return this.em.createQuery("FROM Size", Size.class).getResultList();
    }

}
