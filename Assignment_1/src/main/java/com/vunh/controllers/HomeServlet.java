package com.vunh.controllers;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.vunh.entities.SanPham;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(name = "HomeServletServlet", value = {"/san-pham/hien-thi", "/san-pham/add", "/san-pham/delete/*", "/san-pham/search"})
public class HomeServlet extends HttpServlet {
    private List<SanPham> list;

    public HomeServlet() {
        this.list = new ArrayList<>();
        this.list.add(new SanPham("SP1", "San Pham 1", 10, 1000, "Hang 1", true));
        this.list.add(new SanPham("SP2", "San Pham 2", 10, 1000, "Hang 1", true));
        this.list.add(new SanPham("SP3", "San Pham 3", 10, 1000, "Hang 1", true));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi")) {
            loadForm(req, resp);
        } else if (uri.contains("delete")) {
            delete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add")) {
            add(req, resp);
        } else if (uri.contains("search")) {
            search(req, resp);
        }
    }

    protected void loadForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> danh_muc = Arrays.asList("Hang 1", "Hang 2", "Hang 3");
        req.setAttribute("listDanhMuc", danh_muc);
        req.setAttribute("check", this.list.size() <= 0);
        req.setAttribute("listSanPham", this.list);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.list.remove(Integer.parseInt(req.getParameter("index")));
        resp.sendRedirect("/san-pham/hien-thi");
    }

    protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> danh_muc = Arrays.asList("Hang 1", "Hang 2", "Hang 3");
        List<SanPham> searchList = this.list.stream().filter(sp -> sp.getTenSanPham().equalsIgnoreCase(req.getParameter("searchName"))).collect(Collectors.toList());
        req.setAttribute("listDanhMuc", danh_muc);
        req.setAttribute("listSanPham", searchList);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SanPham sanPham = new SanPham();
            BeanUtils.populate(sanPham, req.getParameterMap());
            this.list.add(sanPham);
            resp.sendRedirect("/san-pham/hien-thi");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}