package com.vunh.Controller;

import java.io.*;

import com.vunh.Model.Employees;
import com.vunh.Service.EmployeeService;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "CtrlAddServlet", value = "/add")
public class CtrlAdd extends HttpServlet {
    private final EmployeeService service = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Views/AddEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employees emp = new Employees();
        emp.setFirstName(req.getParameter("firstName"));
        emp.setLastName(req.getParameter("lastName"));
        emp.setDepartment(req.getParameter("department"));
        emp.setPosition(req.getParameter("position"));
        emp.setSalary(Double.parseDouble(req.getParameter("salary")));

        if(this.service.insertEmployee(emp)){
//            req.setAttribute("employee", this.service.getAll());
//            req.getRequestDispatcher("Views/EmployeePage.jsp").forward(req, resp);
            resp.sendRedirect("admin");
        }else{
            req.getRequestDispatcher("Views/AddEmployee.jsp").forward(req, resp);
        }
    }
}