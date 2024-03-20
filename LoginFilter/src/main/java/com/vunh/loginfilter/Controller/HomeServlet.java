package com.vunh.loginfilter.Controller;

import java.io.*;

import com.vunh.loginfilter.Model.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "HomeServletServlet", value = {"/home", "/logout"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("home")) {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("login-success");
            req.setAttribute("user", user);
            if (!resp.isCommitted()) {
                req.getRequestDispatcher("/Welcome.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/Welcome.jsp");
            }
        } else if (uri.contains("logout")) {
            HttpSession session = req.getSession();
            session.removeAttribute("login-success");
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}