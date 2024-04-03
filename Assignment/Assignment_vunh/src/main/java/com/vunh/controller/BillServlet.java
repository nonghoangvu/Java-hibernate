package com.vunh.controller;

import java.io.*;
import java.util.Date;
import java.util.List;

import com.vunh.entities.Ctsp;
import com.vunh.entities.HoaDon;
import com.vunh.repositories.InvoicesRepositorie;
import com.vunh.repositories.ProductDetailRepositories;
import com.vunh.service.MethodController;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "BillServletServlet", value = {"/bill/index", "/bill/show", "/bill/create", "/bill/store", "/bill/edit", "/bill/update", "/bill/delete"})
public class BillServlet extends HttpServlet implements MethodController {
    private final InvoicesRepositorie invoicesRepositorie = new InvoicesRepositorie();

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
            } else if (uri.contains("update")) {
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
        InvoicesRepositorie invoicesRepositorie = new InvoicesRepositorie();
        Integer keyword = req.getParameter("keyword") == null || req.getParameter("keyword") == "" ? null : Integer.parseInt(req.getParameter("keyword"));
        String status = (req.getParameter("status") == null) ? "" : req.getParameter("status").trim();
        int page = (req.getParameter("page") == null || req.getParameter("page").trim().length() == 0) ? 1 : Integer.parseInt(req.getParameter("page"));
        int limit = (req.getParameter("limit") == null || req.getParameter("limit").trim().length() == 0) ? 10 : Integer.parseInt(req.getParameter("limit"));
        StringBuffer queryString = new StringBuffer("limit=" + limit);
        if (keyword != null) {
            req.setAttribute("keyword", keyword);
            queryString.append("&keyword=" + keyword);
        }
        if (status.length() != 0) {
            req.setAttribute("status", status);
            queryString.append("&status=" + status);
        }
        List<HoaDon> listInvoices = invoicesRepositorie.findInvoices(page, limit, keyword, status);
        req.setAttribute("page", page);
        req.setAttribute("totalPage", listInvoices.size());
        req.setAttribute("keyword", keyword);
        req.setAttribute("TITLE", "INVOICE MANAGE");
        req.setAttribute("listInvoices", listInvoices);
        req.setAttribute("VIEW", "/views/Bill/index.jsp");
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InvoicesRepositorie invoicesRepositorie = new InvoicesRepositorie();
        req.setAttribute("quantitySize", invoicesRepositorie.findAll().size());
        req.setAttribute("listInvoicesDetails", invoicesRepositorie.findInvoices(Integer.parseInt(req.getParameter("id"))).getListHoaDon());
        req.setAttribute("idInvoice", req.getParameter("id"));
        req.setAttribute("TITLE", "INVOICE DETAIL");
        req.setAttribute("VIEW", "/views/Bill/Detail.jsp");
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
        ProductDetailRepositories productDetailRepositories = new ProductDetailRepositories();
        InvoicesRepositorie invoicesRepositorie = new InvoicesRepositorie();
        HoaDon invoice = invoicesRepositorie.findInvoices(Integer.parseInt(req.getParameter("id")));
        if (invoice.getTrangThai().equals("Cancel")) {
            invoice.getListHoaDon().forEach(i -> {
                Ctsp prd = i.getCtsp();
                prd.setSoLuongTon(prd.getSoLuongTon() - i.getSoLuongMua());
                productDetailRepositories.update(prd);
            });
        }
        invoice.setTrangThai("Pending");
        invoice.setNgaySua(new Date());
        this.invoicesRepositorie.update(invoice);
        resp.sendRedirect("/bill/index");
    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HoaDon invoice = this.invoicesRepositorie.findInvoices(Integer.parseInt(req.getParameter("id")));
        this.invoicesRepositorie.delete(invoice);
        resp.sendRedirect("/bill/index");
    }
}