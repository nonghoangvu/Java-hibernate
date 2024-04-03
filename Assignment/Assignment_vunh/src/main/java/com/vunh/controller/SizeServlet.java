package com.vunh.controller;

import java.io.*;
import java.util.Date;
import java.util.List;

import com.vunh.entities.MauSac;
import com.vunh.service.MethodController;
import com.vunh.entities.Size;
import com.vunh.repositories.SizeRepositories;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(name = "SizeServletServlet", value = {"/size/index", "/size/show", "/size/create", "/size/store", "/size/edit", "/size/update", "/size/delete"})
public class SizeServlet extends HttpServlet implements MethodController {
    private final SizeRepositories sizeRepositories = new SizeRepositories();
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
        List<Size> listSize = this.sizeRepositories.findAll(keyword, status);
        if (keyword.length() != 0) {
            req.setAttribute("keyword", keyword);
        }
        if (status.length() != 0) {
            req.setAttribute("status", status);
        }
        req.setAttribute("VIEW", "/views/size/index.jsp");
        req.setAttribute("TITLE", "SIZE MANAGE");
        req.setAttribute("showAlerts", this.showAlerts);
        req.setAttribute("message", this.message);
        req.setAttribute("listSize", listSize);
        this.showAlerts = false;
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("VIEW", "/views/size/create.jsp");
        req.setAttribute("TITLE", "NEW SIZE");
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Size size = new Size();
            BeanUtils.populate(size, req.getParameterMap());
            size.setTrangThai((req.getParameter("trangThai") != null) ? "Activity" : "Inactive");
            size.setNgayTao(new Date());
            size.setNgaySua(new Date());
            if (this.sizeRepositories.save(size)) {
                this.showAlerts = true;
                this.message = "A new size has been added";
                resp.sendRedirect("/size/index");
            } else {
                resp.sendRedirect("/size/create");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("VIEW", "/views/size/edit.jsp");
        req.setAttribute("TITLE", "UPDATE SIZE");
        req.setAttribute("size", this.sizeRepositories.findById(id));
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Size size = this.sizeRepositories.findById(id);
            BeanUtils.populate(size, req.getParameterMap());
            size.setTrangThai((req.getParameter("trangThai") != null) ? "Activity" : "Inactive");
            size.setNgaySua(new Date());
            if (this.sizeRepositories.update(size)) {
                this.showAlerts = true;
                this.message = "Edited a size";
                resp.sendRedirect("/size/index");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.sizeRepositories.delete(this.sizeRepositories.findById(id));
        this.message = "Successfully deleted a size";
        this.showAlerts = true;
        resp.sendRedirect("/size/index");
    }
}