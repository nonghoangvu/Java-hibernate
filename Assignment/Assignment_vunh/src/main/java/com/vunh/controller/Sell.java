package com.vunh.controller;

import java.io.*;
import java.util.Date;
import java.util.List;

import com.vunh.entities.Ctsp;
import com.vunh.entities.Hdct;
import com.vunh.entities.HoaDon;
import com.vunh.entities.KhachHang;
import com.vunh.repositories.*;
import com.vunh.service.MethodController;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(name = "SellServlet", value = {"/sell/index", "/sell/addCustomer", "/sell/newInvoices", "/sell/addToCart", "/sell/deleteProductInvoice", "/sell/pay", "/sell/cancelInvoices", "/sell/createOrEditCustomer"})
public class Sell extends HttpServlet {
    private final ProductDetailRepositories productDetailRepositories = new ProductDetailRepositories();
    private final InvoicesRepositorie invoicesRepositorie = new InvoicesRepositorie();
    private final InvoicesDetailRepostories invoicesDetailRepostories = new InvoicesDetailRepostories();
    private final CustomerRepositories customerRepositories = new CustomerRepositories();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!resp.isCommitted()) {
            String uri = req.getRequestURI();
            if (uri.contains("index")) {
                this.index(req, resp);
            } else if (uri.contains("newInvoices")) {
                this.newInvoices(req, resp);
            } else if (uri.contains("cancelInvoices")) {
                this.cancelInvoices(req, resp);
            } else if (uri.contains("addToCart")) {
                this.addToCart(req, resp);
            } else if (uri.contains("delete")) {
                this.deleteProductInvoice(req, resp);
            } else if (uri.contains("addCustomer")) {
                this.addCustomer(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("pay")) {
            this.pay(req, resp);
        } else if (uri.contains("createOrEditCustomer")) {
            this.createOrEditCustomer(req, resp);
        }
    }

    private void setAttributeGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ColorRepositories colorRepositories = new ColorRepositories();
        SizeRepositories sizeRepositories = new SizeRepositories();
        ProductDetailRepositories productDetailRepositories = new ProductDetailRepositories();
        InvoicesRepositorie invoicesRepositorie = new InvoicesRepositorie();
        int id = req.getParameter("id_detail") != null ? Integer.parseInt(req.getParameter("id_detail")) : 0;
        int page = (req.getParameter("page") == null || req.getParameter("page").trim().length() == 0) ? 1 : Integer.parseInt(req.getParameter("page"));
        int limit = (req.getParameter("limit") == null || req.getParameter("limit").trim().length() == 0) ? 10 : Integer.parseInt(req.getParameter("limit"));
        StringBuffer queryString = new StringBuffer("limit=" + limit);
        String keyword = req.getParameter("keyword") != null ? req.getParameter("keyword") : "";
        List<Ctsp> listProduct = productDetailRepositories.findAll(page, limit, keyword);
        HoaDon hoaDon = invoicesRepositorie.findById(id);
        long totalPage = (productDetailRepositories.countPage() / limit) + 1;
        if (keyword.length() != 0) {
            req.setAttribute("keyword", keyword);
            queryString.append("&keyword=" + keyword);
        }
        if (hoaDon != null && hoaDon.getListHoaDon() != null) {
            Double totalMoney = hoaDon.getListHoaDon().stream().mapToDouble(money -> money.getGiaBan() * money.getSoLuongMua()).sum();
            req.setAttribute("totalMoney", String.format("%.2f", totalMoney));
        }
        req.setAttribute("page", page);
        req.setAttribute("id_detail", id);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("keyword", keyword);
        req.setAttribute("queryString", queryString);
        req.setAttribute("listColor", colorRepositories.findAll());
        req.setAttribute("listSize", sizeRepositories.findAll());
        req.setAttribute("listProductDetail", listProduct);
        req.setAttribute("listInvoices", invoicesRepositorie.findAll());
        req.setAttribute("invoicesDetails", hoaDon);
        req.setAttribute("TITLE", "SALES AT THE COUNTER");
        req.setAttribute("VIEW", "/views/Sell/index.jsp");
    }

    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAttributeGet(req, resp);
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    public void newInvoices(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HoaDon invoice = new HoaDon();
        invoice.setTrangThai("Pending");
        invoice.setNgayTao(new Date());
        invoice.setNgaySua(new Date());
        if (this.invoicesRepositorie.save(invoice)) {
            resp.sendRedirect("/sell/index");
        }
    }

    public void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        Ctsp prd = this.productDetailRepositories.findById(Integer.parseInt(req.getParameter("id_product")));
        prd.setSoLuongTon(prd.getSoLuongTon() - quantity);
        HoaDon invoices = this.invoicesRepositorie.findById(Integer.parseInt(req.getParameter("id_invoice")));
        Hdct invoicesDetail = new Hdct();
        invoicesDetail.setHoaDon(invoices);
        invoicesDetail.setCtsp(prd);
        invoicesDetail.setSoLuongMua(quantity);
        invoicesDetail.setGiaBan(prd.getGiaBan());
        invoicesDetail.setTongTien(quantity * prd.getGiaBan());
        invoicesDetail.setTrangThai("Activity");
        invoicesDetail.setNgayTao(new Date());
        invoicesDetail.setNgaySua(new Date());
        if (this.invoicesDetailRepostories.existsProduct(invoices, prd)) {
            if (this.productDetailRepositories.update(prd) && this.invoicesDetailRepostories.save(invoicesDetail)) {
                resp.sendRedirect("/sell/index?id_detail=" + invoices.getId());
            }
        } else {
            invoicesDetail = this.invoicesDetailRepostories.findByInvoiceAndProduct(invoices, prd);
            invoicesDetail.setSoLuongMua(invoicesDetail.getSoLuongMua() + quantity);
            invoicesDetail.setTongTien(invoicesDetail.getSoLuongMua() * prd.getGiaBan());
            if (this.productDetailRepositories.update(prd) && this.invoicesDetailRepostories.update(invoicesDetail)) {
                resp.sendRedirect("/sell/index?id_detail=" + invoices.getId());
            }
        }
    }

    public void pay(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HoaDon invoice = this.invoicesRepositorie.findById(Integer.parseInt(req.getParameter("idInvoices")));
        invoice.setTrangThai("Paid");
        invoice.setNgaySua(new Date());
        if (this.invoicesRepositorie.update(invoice)) {
            resp.sendRedirect("/sell/index");
        }
    }

    public void cancelInvoices(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InvoicesRepositorie invoicesRepositorie = new InvoicesRepositorie();
        HoaDon invoice = invoicesRepositorie.findById(Integer.parseInt(req.getParameter("id")));
        invoice.setNgaySua(new Date());
        invoice.setTrangThai("Cancel");
        invoice.getListHoaDon().forEach(i -> {
            Ctsp prd = i.getCtsp();
            prd.setSoLuongTon(prd.getSoLuongTon() + i.getSoLuongMua());
            this.productDetailRepositories.update(prd);
        });
        if (this.invoicesRepositorie.update(invoice)) {
            resp.sendRedirect("/sell/index");
        }
    }

    public void deleteProductInvoice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Hdct invoiceDetail = this.invoicesDetailRepostories.findById(Integer.parseInt(req.getParameter("id")));
        Ctsp prd = invoiceDetail.getCtsp();
        prd.setSoLuongTon(prd.getSoLuongTon() + invoiceDetail.getSoLuongMua());
        if (this.productDetailRepositories.update(prd) && invoicesDetailRepostories.delete(invoiceDetail)) {
            resp.sendRedirect("/sell/index?id_detail=" + invoiceDetail.getHoaDon().getId());
        }
    }

    public void addCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numberPhone = req.getParameter("searchCustomer").trim();
        String idInvoices = req.getParameter("id_detail").trim();
        KhachHang customer = this.customerRepositories.findByPhone(numberPhone);
        HoaDon invoices = this.invoicesRepositorie.findById(Integer.parseInt(idInvoices));
        invoices.setKhachHang(customer);
        this.invoicesRepositorie.update(invoices);
        resp.sendRedirect("/sell/index?id_detail=" + idInvoices);
    }

    private void createOrEditCustomer(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String idInvoices = req.getParameter("id_detail").trim();
            KhachHang customer = new KhachHang();
            BeanUtils.populate(customer, req.getParameterMap());
            KhachHang customerFind = this.customerRepositories.findByPhoneCheck(customer.getSdt());
            if (customerFind == null) {
                //Create
                customer.setTrangThai("Activity");
                customer.setNgayTao(new Date());
                customer.setNgaySua(new Date());
                this.customerRepositories.save(customer);
                resp.sendRedirect("/sell/index?id_detail=" + idInvoices);
            } else {
                //update
                customerFind.setTrangThai("Activity");
                customerFind.setHoTen(customer.getHoTen());
                customerFind.setDiaChi(customer.getDiaChi());
                customer.setNgaySua(new Date());
                this.customerRepositories.update(customerFind);
                resp.sendRedirect("/sell/index?id_detail=" + idInvoices);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}