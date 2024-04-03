package com.vunh.Controller;

import java.io.*;
import java.util.List;

import com.vunh.Model.Employees;
import com.vunh.Service.EmployeeService;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "CtrlManagerServlet", value = {"/admin/*", "/delete/*"})
public class CtrlManager extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService service = new EmployeeService();
        if (req.getRequestURI().contains("delete")) {
            if (service.deleteEmployee(Integer.valueOf(req.getParameter("id")))) {
                resp.sendRedirect("admin?index=0");
            }
        } else {

            List<Employees> lsistEmployees = service.getAll(Integer.parseInt(req.getParameter("index")));
            long page = service.getCountPage();
            int size = 40;
            long endPage = page / size;
            if (page % size != 0) {
                endPage++;
            }
            req.setAttribute("endPage", endPage);
            req.setAttribute("employee", lsistEmployees);
            req.getRequestDispatcher("Views/EmployeePage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}