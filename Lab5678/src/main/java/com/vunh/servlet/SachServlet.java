package com.vunh.servlet;

import java.io.*;

import com.vunh.entities.Sach;
import com.vunh.repositories.SachRepositories;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(name = "SachServletServlet", value = {"/hien-thi", "/add", "/detail/*", "/delete"})
public class SachServlet extends HttpServlet {
    private final SachRepositories sachRepositories = new SachRepositories();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(req, resp);
        } else if (uri.contains("delete")) {
            this.delete(req, resp);
        } else if (uri.contains("detail")) {
            this.detail(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add")) {
            this.add(req, resp);
        }
    }

    protected void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSach", this.sachRepositories.findAll());
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.sachRepositories.delete(this.sachRepositories.findByID(Integer.parseInt(req.getParameter("id"))));
        resp.sendRedirect("/hien-thi");
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Sach sach = new Sach();
            BeanUtils.populate(sach, req.getParameterMap());
            if (this.sachRepositories.save(sach)) {
                resp.sendRedirect("/hien-thi");
            }
        } catch (Exception e) {
            return;
        }
    }


    protected void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Sach sach = this.sachRepositories.findByID(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("s", sach);
        req.getRequestDispatcher("/Detail.jsp").forward(req, resp);
    }
}