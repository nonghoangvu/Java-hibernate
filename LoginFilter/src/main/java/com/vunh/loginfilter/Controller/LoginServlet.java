package com.vunh.loginfilter.Controller;

import java.io.*;

import com.vunh.loginfilter.Model.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(name = "LoginServletServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("LoginForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = new User();
            BeanUtils.populate(user, req.getParameterMap());
            HttpSession session = req.getSession();
            if(user.getUsername().equals("admin") && user.getPassword().equals("123")){
                session.setAttribute("login-success", user);
                resp.sendRedirect("/home");
            }else{
                resp.sendRedirect("/login");
            }
        }catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}