package com.vunh.repositories;

import com.vunh.entities.Ctsp;
import com.vunh.entities.Hdct;
import com.vunh.entities.HoaDon;
import com.vunh.service.CRUD;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class InvoicesDetailRepostories extends CRUD<Hdct> {
    @Override
    public List<Hdct> findAll() {
        return null;
    }

    @Override
    public Hdct findById(int id) {
        return this.em.createQuery("FROM Hdct WHERE id = :id", Hdct.class).setParameter("id", id).getSingleResult();
    }

    public Boolean existsProduct(HoaDon invoice, Ctsp prd) {
        try {
            TypedQuery<Hdct> query = this.em.createQuery("FROM Hdct WHERE hoaDon.id = :id_invoice AND ctsp.id = :prd", Hdct.class).setParameter("id_invoice", invoice.getId()).setParameter("prd", prd.getId());
            return query.getSingleResult() == null;
        } catch (Exception e) {
            return true;
        }
    }

    public Hdct findByInvoiceAndProduct(HoaDon invoice, Ctsp prd) {
        TypedQuery<Hdct> query = this.em.createQuery("FROM Hdct WHERE hoaDon.id = :id_invoice AND ctsp.id = :prd", Hdct.class).setParameter("id_invoice", invoice.getId()).setParameter("prd", prd.getId());
        return query.getSingleResult();
    }
}
