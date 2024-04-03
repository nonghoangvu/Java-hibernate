package com.vunh.repositories;

import com.vunh.entities.MauSac;
import com.vunh.service.CRUD;
import com.vunh.entities.Size;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SizeRepositories extends CRUD<Size> {
    @Override
    public List<Size> findAll() {
        TypedQuery<Size> query = this.em.createQuery("FROM Size", Size.class);
        return query.getResultList();
    }

    public List<Size> findAll(String keyword, String status) {
        try {
            StringBuffer sql = new StringBuffer("SELECT sz FROM Size sz ");
            Map<String, Object> parameters = new HashMap<>();
            if (keyword != null || status != null) {
                sql.append(" WHERE ");
                if (keyword != null) {
                    sql.append(" ((sz.maSize LIKE :keyword) OR (sz.tenSize LIKE :keyword)) ");
                    parameters.put("keyword", "%" + keyword + "%");
                }
                if (status != null) {
                    sql.append((keyword != null) ? " AND " : "");
                    sql.append("sz.trangThai LIKE :status");
                    parameters.put("status", "%" + status + "%");
                }
            }
            TypedQuery<Size> query = this.em.createQuery(sql.toString(), Size.class);
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            return query.getResultList();
        } catch (Exception e) {
            throw new NullPointerException("Not found!");
        }
    }

    @Override
    public Size findById(int id) {
        return this.em.find(Size.class, id);
    }
}
