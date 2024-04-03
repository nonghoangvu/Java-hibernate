package com.vunh.repositories;

import com.vunh.service.CRUD;
import com.vunh.entities.SanPham;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositories extends CRUD<SanPham> {
    @Override
    public List<SanPham> findAll() {
        TypedQuery<SanPham> query = this.em.createQuery("FROM SanPham ", SanPham.class);
        return query.getResultList();
    }
    public long countPage(){
        return this.em.createQuery("SELECT COUNT(sp.id) FROM SanPham sp", Long.class).getSingleResult();
    }
    public List<SanPham> findAll(int page, int limit, String keyword, String status) {
        try {
            StringBuffer sql = new StringBuffer("SELECT sp FROM SanPham sp");
            Map<String, Object> parameters = new HashMap<>();
            if(keyword != null || status != null){
                sql.append(" WHERE ");
                if(keyword != null){
                    sql.append(" ((sp.maSanPham LIKE :keyword) OR (sp.tenSanPham LIKE :keyword)) ");
                    parameters.put("keyword", "%" + keyword + "%");
                }
                if(status != null){
                    sql.append((keyword != null) ? " AND " : "");
                    sql.append("sp.trangThai LIKE :status");
                    parameters.put("status", "%" + status + "%");
                }
                int offset = (page - 1) * limit;
                TypedQuery<SanPham> query = this.em.createQuery(sql.toString(), SanPham.class);
                query.setFirstResult(offset);
                query.setMaxResults(limit);
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
                return query.getResultList();
            }
        }catch (Exception exception){
            throw exception;
        }
        return null;
    }


    @Override
    public SanPham findById(int id) {
        return this.em.find(SanPham.class, id);
    }
}
