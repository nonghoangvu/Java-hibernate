package com.vunh.layoutdemo;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "CtrManagementServlet", value = {"/home", "/link"})
public class CtrManagement extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().contains("home")){
            req.setAttribute("VIEW", "/Views/Home.jsp");
        } else if (req.getRequestURI().contains("link")) {
            req.setAttribute("VIEW", "/Views/Link.jsp");
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}