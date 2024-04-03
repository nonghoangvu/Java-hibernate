package com.vunh.controller;

import java.io.*;
import java.util.Date;
import java.util.List;

import com.vunh.entities.DanhMuc;
import com.vunh.service.MethodController;
import com.vunh.entities.MauSac;
import com.vunh.repositories.ColorRepositories;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(name = "ColorServletServlet", value = {"/color/index", "/color/show", "/color/create", "/color/store", "/color/edit", "/color/update", "/color/delete"})
public class ColorServlet extends HttpServlet implements MethodController {
    private final ColorRepositories colorRepositories = new ColorRepositories();
    private boolean showAlerts = false;
    private String message = "Changes saved";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!resp.isCommitted()){
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
        List<MauSac> listColors = this.colorRepositories.findAll(keyword, status);
        if (keyword.length() != 0) {
            req.setAttribute("keyword", keyword);
        }
        if (status.length() != 0) {
            req.setAttribute("status", status);
        }

        req.setAttribute("VIEW", "/views/color/index.jsp");
        req.setAttribute("TITLE", "COLOR MANAGE");
        req.setAttribute("showAlerts", this.showAlerts);
        req.setAttribute("message", this.message);
        req.setAttribute("listColor", listColors);
        this.showAlerts = false;
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);

    }

    @Override
    public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("VIEW", "/views/color/create.jsp");
        req.setAttribute("TITLE", "NEW COLOR");
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            MauSac mauSac = new MauSac();
            BeanUtils.populate(mauSac, req.getParameterMap());
            mauSac.setTrangThai((req.getParameter("trangThai") != null) ? "Activity" : "Inactive");
            mauSac.setNgayTao(new Date());
            mauSac.setNgaySua(new Date());
            if (this.colorRepositories.save(mauSac)) {
                this.showAlerts = true;
                this.message = "A new color has been added";
                resp.sendRedirect("/color/index");
            } else {
                resp.sendRedirect("/color/create");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("VIEW", "/views/color/edit.jsp");
        req.setAttribute("TITLE", "UPDATE COLOR");
        req.setAttribute("color", this.colorRepositories.findById(id));
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            MauSac mauSac = this.colorRepositories.findById(id);
            BeanUtils.populate(mauSac, req.getParameterMap());
            mauSac.setTrangThai((req.getParameter("trangThai") != null) ? "Activity" : "Inactive");
            mauSac.setNgaySua(new Date());
            if (this.colorRepositories.update(mauSac)) {
                this.showAlerts = true;
                this.message = "Edited a color";
                resp.sendRedirect("/color/index");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.colorRepositories.delete(this.colorRepositories.findById(id));
        this.message = "Successfully deleted a color";
        this.showAlerts = true;
        resp.sendRedirect("/color/index");
    }
}