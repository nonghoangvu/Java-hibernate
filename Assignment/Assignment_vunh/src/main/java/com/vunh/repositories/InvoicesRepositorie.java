package com.vunh.repositories;

import com.vunh.entities.HoaDon;
import com.vunh.service.CRUD;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoicesRepositorie extends CRUD<HoaDon> {
    @Override
    public List<HoaDon> findAll() {
        return this.em.createQuery("FROM HoaDon WHERE trangThai LIKE 'Pending'", HoaDon.class).getResultList();
    }

    public List<HoaDon> findInvoices() {
        return this.em.createQuery("FROM HoaDon WHERE trangThai NOT LIKE 'Pending' ORDER BY id desc ", HoaDon.class).getResultList();
    }

    public List<HoaDon> findInvoices(int page, int limit, Integer keyword, String status) {
        try {
            StringBuffer sql = new StringBuffer("SELECT inv FROM HoaDon inv");
            Map<String, Object> parameters = new HashMap<>();
            if (keyword != null || status != null) {
                sql.append(" WHERE ");
                if (keyword != null) {
                    sql.append(" (inv.id = :keyword)");
                    parameters.put("keyword", keyword);
                }
                if (status != null) {
                    sql.append((keyword != null) ? " AND " : "");
                    sql.append("inv.trangThai LIKE :status AND trangThai NOT LIKE 'Pending' ");
                    parameters.put("status", "%" + status + "%");
                }
                int offset = (page - 1) * limit;
                sql.append(" ORDER BY inv.ngaySua desc");
                TypedQuery<HoaDon> query = this.em.createQuery(sql.toString(), HoaDon.class);
                query.setFirstResult(offset);
                query.setMaxResults(limit);
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
                return query.getResultList();
            }
        } catch (Exception exception) {
            throw exception;
        }
        return null;
//        return this.em.createQuery("FROM HoaDon WHERE trangThai NOT LIKE 'Pending' ORDER BY id desc ", HoaDon.class).getResultList();
    }

    @Override
    public HoaDon findById(int id) {
        try {
            return this.em.createQuery("FROM HoaDon WHERE trangThai LIKE 'Pending' AND id = :did", HoaDon.class)
                    .setParameter("did", id)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public HoaDon findInvoices(int id) {
        return this.em.find(HoaDon.class, id);
    }

    public List<HoaDon> findInvoicesByCustomer(int id) {
        return this.em.createQuery("FROM HoaDon WHERE khachHang.id = :id", HoaDon.class).setParameter("id", id).getResultList();
    }
}
