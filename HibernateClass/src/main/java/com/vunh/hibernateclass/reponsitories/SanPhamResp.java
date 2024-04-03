package com.vunh.hibernateclass.reponsitories;

import com.vunh.hibernateclass.entities.DanhMuc;
import com.vunh.hibernateclass.entities.SanPham;
import com.vunh.hibernateclass.utils.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SanPhamResp {
    private final EntityManager em = JPAUtil.getEntityManager();

    public List<SanPham> findAll() {
        return this.em.createQuery("FROM SanPham ", SanPham.class).getResultList();
    }
}
