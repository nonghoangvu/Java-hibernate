package com.vunh.Controller;

import java.io.*;
import java.rmi.server.ExportException;

import com.vunh.Model.Employees;
import com.vunh.Service.EmployeeService;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.apache.commons.beanutils.BeanUtils;

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
        try {
            Employees emp = this.service.getEmployee(Integer.valueOf(req.getParameter("id")));
            BeanUtils.populate(emp, req.getParameterMap());
            if(this.service.updateEmployee(emp)){
                resp.sendRedirect("admin?index=0");
            }else{
                req.setAttribute("emp", this.service.getEmployee(Integer.parseInt(req.getParameter("id"))));
                req.getRequestDispatcher("Views/Update.jsp").forward(req, resp);
            }
        }catch (Exception exception){
            throw new ExportException("Error something!");
        }
    }


}