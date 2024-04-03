package com.vunh.hibernateclass.controller;

import java.io.*;

import com.vunh.hibernateclass.reponsitories.SanPhamResp;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "SanPhamServletServlet", value = "/san-pham")
public class SanPhamServlet extends HttpServlet {
    private final SanPhamResp list = new SanPhamResp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.list.findAll().forEach(s -> {
            System.out.println("Ma SP: " + s.getMaSanPham() + " - Ten SP: " + s.getTenSanPham() + " - Danh muc: " + s.getDanhMuc().getTenDanhMuc());
        });
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}