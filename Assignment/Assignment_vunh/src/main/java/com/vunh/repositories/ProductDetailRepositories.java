package com.vunh.repositories;

import com.vunh.service.CRUD;
import com.vunh.entities.Ctsp;
import jakarta.persistence.TypedQuery;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDetailRepositories extends CRUD<Ctsp> {
    @Override
    public List<Ctsp> findAll() {
        TypedQuery<Ctsp> query = this.em.createQuery("FROM Ctsp WHERE sanPham.trangThai LIKE 'Activity' AND trangThai LIKE 'Activity' AND soLuongTon > 0", Ctsp.class);
        return query.getResultList();
    }

    public List<Ctsp> findAll(int page, int limit, String keyword) {
        StringBuffer sql = new StringBuffer("SELECT c FROM Ctsp c WHERE c.sanPham.trangThai LIKE 'Activity' AND c.trangThai LIKE 'Activity' AND c.soLuongTon > 0");
        try {
            Map<String, Object> parameters = new HashMap<>();
            if (keyword != null) {
                sql.append(" AND (c.sanPham.maSanPham LIKE :keyword OR c.sanPham.tenSanPham LIKE :keyword)");
                parameters.put("keyword", "%" + keyword + "%");
            }
            int offset = (page - 1) * limit;
            TypedQuery<Ctsp> query = this.em.createQuery(sql.toString(), Ctsp.class);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Not found!", e);
        }
    }

    public long countPage() {
        return this.em.createQuery("SELECT COUNT(sp.id) FROM Ctsp sp WHERE sanPham.trangThai LIKE 'Activity' AND sp.trangThai = 'Activity'", Long.class).getSingleResult();
    }

    public List<Ctsp> findAll(Integer id) {
        TypedQuery<Ctsp> query = this.em.createQuery("FROM Ctsp WHERE sanPham.id = :id", Ctsp.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public Ctsp findById(int id) {
        return this.em.find(Ctsp.class, id);
    }

    public Boolean existsProduct(Ctsp prd) {
        TypedQuery<Ctsp> query = this.em.createQuery("FROM Ctsp WHERE sanPham.id = :id", Ctsp.class).setParameter("id", prd.getId());
        return query.getSingleResult() == null;
    }
}
