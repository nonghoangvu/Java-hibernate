package com.vunh.filtertutorself;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "CtrlHomeServlet", value = {"/home", "/admin"})
public class CtrlHome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().contains("home")) {
            req.getRequestDispatcher("/Views/Home.jsp").forward(req, resp);
        } else if (req.getRequestURI().contains("admin")) {
            req.getRequestDispatcher("/Views/Admin.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}