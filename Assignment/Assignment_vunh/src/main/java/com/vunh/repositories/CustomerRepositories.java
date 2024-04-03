package com.vunh.repositories;

import com.vunh.entities.KhachHang;
import com.vunh.service.CRUD;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CustomerRepositories extends CRUD<KhachHang> {
    @Override
    public List<KhachHang> findAll() {
        TypedQuery<KhachHang> query = this.em.createQuery("FROM KhachHang ", KhachHang.class);
        return query.getResultList();
    }

    @Override
    public KhachHang findById(int id) {
        return this.em.find(KhachHang.class, id);
    }
    public KhachHang findByPhone(String phone) {
        try {
            return this.em.createQuery("FROM KhachHang WHERE trangThai LIKE 'Activity' AND sdt LIKE :phone", KhachHang.class).setParameter("phone", phone).getSingleResult();
        }catch (Exception e){
            return null;
        }
    }
    public KhachHang findByPhoneCheck(String phone) {
        try {
            return this.em.createQuery("FROM KhachHang WHERE  sdt LIKE :phone", KhachHang.class).setParameter("phone", phone).getSingleResult();
        }catch (Exception e){
            return null;
        }
    }
}
