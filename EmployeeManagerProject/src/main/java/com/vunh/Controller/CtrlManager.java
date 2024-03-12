package com.vunh.Controller;

import java.io.*;

import com.vunh.Service.EmployeeService;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "CtrlManagerServlet", value = {"/admin", "/delete/*"})
public class CtrlManager extends HttpServlet {
    private final EmployeeService service = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (req.getRequestURI().contains("delete")) {
            if (this.service.deleteEmployee(Integer.valueOf(id))) {
                resp.sendRedirect("admin");
            }
        }
        req.setAttribute("employee", this.service.getAll());
        req.getRequestDispatcher("Views/EmployeePage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}