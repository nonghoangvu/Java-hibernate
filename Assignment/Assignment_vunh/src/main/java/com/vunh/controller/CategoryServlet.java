package com.vunh.controller;

import java.io.*;
import java.util.Date;
import java.util.List;

import com.vunh.entities.SanPham;
import com.vunh.service.MethodController;
import com.vunh.entities.DanhMuc;
import com.vunh.repositories.CategoryRepositories;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(name = "CategoryServletServlet", value = {"/category/index", "/category/show", "/category/create", "/category/store", "/category/edit", "/category/update", "/category/delete"})
public class CategoryServlet extends HttpServlet implements MethodController {
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
        String keyword = (s1 == null) ? "" : s1.trim();
        String status = (s2 == null) ? "" : s2.trim();
        List<DanhMuc> listCategory = this.categoryRepositories.findAll(keyword, status);
        if (keyword.length() != 0) {
            req.setAttribute("keyword", keyword);
        }
        if (status.length() != 0) {
            req.setAttribute("status", status);
        }
        req.setAttribute("VIEW", "/views/category/index.jsp");
        req.setAttribute("TITLE", "CATEGORY MANAGE");
        req.setAttribute("showAlerts", this.showAlerts);
        req.setAttribute("message", this.message);
        req.setAttribute("listCategory", listCategory);
        this.showAlerts = false;
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("VIEW", "/views/category/create.jsp");
        req.setAttribute("TITLE", "NEW CATEGORY");
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DanhMuc danhMuc = new DanhMuc();
            BeanUtils.populate(danhMuc, req.getParameterMap());
            danhMuc.setTrangThai((req.getParameter("trangThai") != null) ? "Activity" : "Inactive");
            danhMuc.setNgayTao(new Date());
            danhMuc.setNgaySua(new Date());
            if (this.categoryRepositories.save(danhMuc)) {
                this.showAlerts = true;
                this.message = "A new category has been added";
                resp.sendRedirect("/category/index");
            } else {
                resp.sendRedirect("/category/create");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("VIEW", "/views/category/edit.jsp");
        req.setAttribute("TITLE", "UPDATE CATEGORY");
        req.setAttribute("category", this.categoryRepositories.findById(id));
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            DanhMuc danhMuc = this.categoryRepositories.findById(id);
            BeanUtils.populate(danhMuc, req.getParameterMap());
            danhMuc.setTrangThai((req.getParameter("trangThai") != null) ? "Activity" : "Inactive");
            danhMuc.setNgaySua(new Date());
            if (this.categoryRepositories.update(danhMuc)) {
                this.showAlerts = true;
                this.message = "Edited a category";
                resp.sendRedirect("/category/index");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.categoryRepositories.delete(this.categoryRepositories.findById(id));
        this.message = "Successfully deleted a category";
        this.showAlerts = true;
        resp.sendRedirect("/category/index");
    }

}