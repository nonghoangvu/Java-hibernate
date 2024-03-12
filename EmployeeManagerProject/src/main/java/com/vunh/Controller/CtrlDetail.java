package com.vunh.Controller;

import java.io.*;

import com.vunh.Service.EmployeeService;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "CtrlDetailServlet", value = "/detail/*")
public class CtrlDetail extends HttpServlet {
    private final EmployeeService service = new EmployeeService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("emp", this.service.getEmployee(Integer.valueOf(req.getParameter("id"))));
            req.getRequestDispatcher("Views/Detail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}