package com.vunh.Controller;

import java.io.*;

import com.vunh.Model.Employees;
import com.vunh.Service.EmployeeService;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(name = "CtrlAddServlet", value = "/add")
public class CtrlAdd extends HttpServlet {
    private final EmployeeService service = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Views/AddEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Employees emp = new Employees();
            BeanUtils.populate(emp, req.getParameterMap());
            if (this.service.insertEmployee(emp)) {
                resp.sendRedirect("admin?index=0");
            } else {
                req.getRequestDispatcher("Views/AddEmployee.jsp").forward(req, resp);
            }
        }catch (Exception e){
            throw new EOFException("Error something!");
        }
    }
}