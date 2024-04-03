package com.vunh.controller;

import java.io.*;
import java.util.Date;

import com.vunh.entities.KhachHang;
import com.vunh.repositories.CustomerRepositories;
import com.vunh.repositories.InvoicesRepositorie;
import com.vunh.service.MethodController;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "CustomerServletServlet", value = {"/customer/index", "/customer/show", "/customer/create", "/customer/store", "/customer/edit", "/customer/update", "/customer/delete"})
public class CustomerServlet extends HttpServlet implements MethodController {
    private final CustomerRepositories customerRepositories = new CustomerRepositories();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!resp.isCommitted()) {
            String uri = req.getRequestURI();
            if (uri.contains("index")) {
                this.index(req, resp);
            } else if (uri.contains("create")) {
                this.create(req, resp);
            } else if (uri.contains("delete")) {
                this.delete(req, resp);
            } else if (uri.contains("edit")) {
                this.edit(req, resp);
            } else if (uri.contains("show")) {
                this.show(req, resp);
            }else if (uri.contains("update")) {
                this.update(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("store")) {
            this.store(req, resp);
        }
    }

    @Override
    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerRepositories customerRepositories = new CustomerRepositories();
        req.setAttribute("listCustomers", customerRepositories.findAll());
        req.setAttribute("TITLE", "CUSTOMER MANAGE");
        req.setAttribute("VIEW", "/views/customer/index.jsp");
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InvoicesRepositorie invoicesRepositorie = new InvoicesRepositorie();
        req.setAttribute("customer", this.customerRepositories.findById(Integer.parseInt(req.getParameter("id"))));
        req.setAttribute("invoices", invoicesRepositorie.findInvoicesByCustomer(Integer.parseInt(req.getParameter("id"))));
        req.setAttribute("TITLE", "PURCHASE HISTORY");
        req.setAttribute("VIEW", "/views/customer/Detail.jsp");
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KhachHang customer = this.customerRepositories.findById(Integer.parseInt(req.getParameter("id")));
        customer.setNgaySua(new Date());
        customer.setTrangThai(req.getParameter("value"));
        this.customerRepositories.update(customer);
        resp.sendRedirect("/customer/index");
    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}