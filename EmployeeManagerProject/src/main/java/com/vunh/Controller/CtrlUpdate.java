package com.vunh.Controller;

import java.io.*;

import com.vunh.Model.Employees;
import com.vunh.Service.EmployeeService;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "CtrlUpdateServlet", value = "/edit/*")
public class CtrlUpdate extends HttpServlet {
    private final EmployeeService service = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("emp", this.service.getEmployee(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("Views/Update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employees emp = this.service.getEmployee(Integer.valueOf(req.getParameter("id")));
        emp.setFirstName(req.getParameter("firstName"));
        emp.setLastName(req.getParameter("lastName"));
        emp.setDepartment(req.getParameter("department"));
        emp.setPosition(req.getParameter("position"));
        emp.setSalary(Double.parseDouble(req.getParameter("salary")));
        if(this.service.updateEmployee(emp)){
            resp.sendRedirect("admin");
        }else{
            req.getRequestDispatcher("Views/Update.jsp").forward(req, resp);
        }
    }
}