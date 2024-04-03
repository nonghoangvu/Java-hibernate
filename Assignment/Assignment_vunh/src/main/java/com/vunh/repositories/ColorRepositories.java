package com.vunh.repositories;

import com.vunh.entities.MauSac;
import com.vunh.service.CRUD;
import com.vunh.entities.MauSac;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColorRepositories extends CRUD<MauSac> {
    @Override
    public List<MauSac> findAll() {
        TypedQuery<MauSac> query = this.em.createQuery("FROM MauSac", MauSac.class);
        return query.getResultList();
    }
    public List<MauSac> findAll(String keyword, String status) {
        try {
            StringBuffer sql = new StringBuffer("SELECT c FROM MauSac c ");
            Map<String, Object> parameters = new HashMap<>();
            if (keyword != null || status != null) {
                sql.append(" WHERE ");
                if (keyword != null) {
                    sql.append(" ((c.maMau LIKE :keyword) OR (c.tenMau LIKE :keyword)) ");
                    parameters.put("keyword", "%" + keyword + "%");
                }
                if (status != null) {
                    sql.append((keyword != null) ? " AND " : "");
                    sql.append("c.trangThai LIKE :status");
                    parameters.put("status", "%" + status + "%");
                }
            }
            TypedQuery<MauSac> query = this.em.createQuery(sql.toString(), MauSac.class);
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            return query.getResultList();
        } catch (Exception e) {
            throw new NullPointerException("Not found!");
        }
    }

    @Override
    public MauSac findById(int id) {
        return this.em.find(MauSac.class, id);
    }
}
