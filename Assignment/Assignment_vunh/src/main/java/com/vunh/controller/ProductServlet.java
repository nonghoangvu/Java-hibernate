package com.vunh.controller;

import java.io.*;
import java.util.Date;
import java.util.List;

import com.vunh.service.MethodController;
import com.vunh.entities.SanPham;
import com.vunh.repositories.CategoryRepositories;
import com.vunh.repositories.ProductRepositories;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "ProductServletServlet", value = {"/product/index", "/product/show", "/product/create", "/product/store", "/product/edit", "/product/update", "/product/delete"})
public class ProductServlet extends HttpServlet implements MethodController {
    private final ProductRepositories productRepositories = new ProductRepositories();
    private final CategoryRepositories categoryRepositories = new CategoryRepositories();
    private boolean showAlerts = false;
    private String message = "Changes saved";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!resp.isCommitted()) {
            String uri = req.getRequestURI();
            if (uri.contains("index")) {
                this.index(req, resp);
            } else if (uri.contains("create")) {
                this.create(req, resp);
            } else if (uri.contains("delete")) {
                this.delete(req, resp);
            } else if (uri.contains("edit")) {
                this.edit(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("store")) {
            this.store(req, resp);
        } else if (uri.contains("update")) {
            this.update(req, resp);
        }
    }

    @Override
    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s1 = req.getParameter("keyword");
        String s2 = req.getParameter("status");
        String s3 = req.getParameter("page");
        String s4 = req.getParameter("limit");

        String keyword = (s1 == null) ? "" : s1.trim();
        String status = (s2 == null) ? "" : s2.trim();
        int page = (s3 == null || s3.trim().length() == 0) ? 1 : Integer.parseInt(s3);
        int limit = (s4 == null || s4.trim().length() == 0) ? 10 : Integer.parseInt(s4);
        StringBuffer queryString = new StringBuffer("limit=" + limit);
        List<SanPham> listPd = this.productRepositories.findAll(page, limit, keyword, status);
        long totalPage = (this.productRepositories.countPage() / limit) + 1;
        if (keyword.length() != 0) {
            req.setAttribute("keyword", keyword);
            queryString.append("&keyword=" + keyword);
        }
        if (status.length() != 0) {
            req.setAttribute("status", status);
            queryString.append("&status=" + status);
        }
        req.setAttribute("queryString", queryString);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("page", page);
        req.setAttribute("queryString", queryString);
        req.setAttribute("VIEW", "/views/product/index.jsp");
        req.setAttribute("TITLE", "PRODUCT MANAGE");
        req.setAttribute("listProduct", listPd);
        req.setAttribute("showAlerts", this.showAlerts);
        req.setAttribute("message", this.message);
        this.showAlerts = false;
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("VIEW", "/views/product/create.jsp");
        req.setAttribute("TITLE", "NEW PRODUCT");
        req.setAttribute("listCategory", this.categoryRepositories.findAll());
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SanPham product = new SanPham();
            product.setMaSanPham(req.getParameter("maSanPham"));
            product.setTenSanPham(req.getParameter("tenSanPham"));
            product.setTrangThai((req.getParameter("trangThai") != null) ? "Activity" : "Inactive");
            product.setNgayTao(new Date());
            product.setNgaySua(new Date());
            product.setDanhMuc(this.categoryRepositories.findById(Integer.parseInt(req.getParameter("danhMuc"))));
            if (this.productRepositories.save(product)) {
                this.showAlerts = true;
                this.message = "A new product has been added";
                resp.sendRedirect("/product/index");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("VIEW", "/views/product/edit.jsp");
        req.setAttribute("TITLE", "UPDATE PRODUCT");
        req.setAttribute("product", this.productRepositories.findById(id));
        req.setAttribute("listCategory", this.categoryRepositories.findAll());
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            SanPham product = this.productRepositories.findById(id);
            product.setMaSanPham(req.getParameter("maSanPham"));
            product.setTenSanPham(req.getParameter("tenSanPham"));
            product.setTrangThai((req.getParameter("trangThai") != null) ? "Activity" : "Inactive");
            product.setNgaySua(new Date());
            product.setDanhMuc(this.categoryRepositories.findById(Integer.parseInt(req.getParameter("danhMuc"))));
            if (this.productRepositories.update(product)) {
                this.showAlerts = true;
                this.message = "Edited a product";
                resp.sendRedirect("/product/index");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.productRepositories.delete(this.productRepositories.findById(id));
        resp.sendRedirect("/product/index");
    }
}