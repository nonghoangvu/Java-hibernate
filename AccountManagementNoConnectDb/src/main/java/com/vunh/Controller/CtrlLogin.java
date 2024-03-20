package com.vunh.Controller;

import java.io.*;

import com.vunh.Model.Account;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "CtrlLoginServlet", value = "/login")
public class CtrlLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Views/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        if(email.equals(Account.username) && password.equals(Account.password)){
            session.setAttribute("user", email);
            resp.sendRedirect("/admin/home");
        }else{
            resp.sendRedirect("/login");
        }
    }
}