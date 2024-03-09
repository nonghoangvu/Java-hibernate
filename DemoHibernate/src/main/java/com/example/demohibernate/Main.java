package com.example.demohibernate;

import com.example.demohibernate.Model.Color;
import com.example.demohibernate.Model.SanPham;
import com.example.demohibernate.Service.ColorService;
import com.example.demohibernate.Util.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        EntityManager em = JPAUtils.getEntityManager();
//        TypedQuery<Color> sanPhamTypedQuery = em.createQuery("SELECT cl FROM Color cl", Color.class);
//        List<Color> list = sanPhamTypedQuery.getResultList();
        ColorService colorService = new ColorService();
        colorService.getAllColor().forEach(sanPham -> {
            System.out.println(sanPham.getLoaiMau());
        });
        System.out.println("Success");


    }
}
