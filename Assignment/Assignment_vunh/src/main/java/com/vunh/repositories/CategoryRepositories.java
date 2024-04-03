package com.vunh.repositories;

import com.vunh.service.CRUD;
import com.vunh.entities.DanhMuc;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryRepositories extends CRUD<DanhMuc> {
    @Override
    public List<DanhMuc> findAll() {
        TypedQuery<DanhMuc> list = this.em.createQuery("SELECT category FROM DanhMuc category", DanhMuc.class);
        return list.getResultList();
    }

    public List<DanhMuc> findAll(String keyword, String status) {
        try {
            StringBuffer sql = new StringBuffer("SELECT c FROM DanhMuc c ");
            Map<String, Object> parameters = new HashMap<>();
            if (keyword != null || status != null) {
                sql.append(" WHERE ");
                if (keyword != null) {
                    sql.append(" ((c.maDanhMuc LIKE :keyword) OR (c.tenDanhMuc LIKE :keyword)) ");
                    parameters.put("keyword", "%" + keyword + "%");
                }
                if (status != null) {
                    sql.append((keyword != null) ? " AND " : "");
                    sql.append("c.trangThai LIKE :status");
                    parameters.put("status", "%" + status + "%");
                }
            }
            TypedQuery<DanhMuc> query = this.em.createQuery(sql.toString(), DanhMuc.class);
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            return query.getResultList();
        } catch (Exception e) {
            throw new NullPointerException("Not found!");
        }
    }

    @Override
    public DanhMuc findById(int id) {
        return this.em.find(DanhMuc.class, id);
    }
}
