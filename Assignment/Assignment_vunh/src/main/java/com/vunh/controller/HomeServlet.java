package com.vunh.controller;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "HomeServletServlet", value = "/home/dashboard")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!resp.isCommitted()) {
            String uri = req.getRequestURI();
            if (!resp.isCommitted()) {
                if (uri.contains("dashboard")) {
                    req.setAttribute("TITLE", "Dashboard");
                    req.setAttribute("VIEW", "/template/Dashboard.jsp");
                    req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}