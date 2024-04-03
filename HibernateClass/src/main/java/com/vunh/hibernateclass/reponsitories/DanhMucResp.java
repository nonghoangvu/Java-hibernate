package com.vunh.hibernateclass.reponsitories;

import com.vunh.hibernateclass.entities.DanhMuc;
import com.vunh.hibernateclass.utils.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DanhMucResp {
    private final EntityManager em = JPAUtil.getEntityManager();

    public List<DanhMuc> findAll() {
        return this.em.createQuery("FROM DanhMuc", DanhMuc.class).getResultList();
    }
}
