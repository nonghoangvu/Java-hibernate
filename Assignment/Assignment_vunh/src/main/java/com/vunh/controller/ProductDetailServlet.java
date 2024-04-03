package com.vunh.controller;

import java.io.*;
import java.util.Date;

import com.vunh.entities.Ctsp;
import com.vunh.entities.MauSac;
import com.vunh.entities.SanPham;
import com.vunh.entities.Size;
import com.vunh.repositories.ColorRepositories;
import com.vunh.repositories.ProductRepositories;
import com.vunh.repositories.SizeRepositories;
import com.vunh.service.MethodController;
import com.vunh.repositories.ProductDetailRepositories;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "ProductDetailServletServlet", value = {"/product-detail/index/*", "/product-detail/show", "/product-detail/create", "/product-detail/store", "/product-detail/edit", "/product-detail/update", "/product-detail/delete"})
public class ProductDetailServlet extends HttpServlet implements MethodController {
    private final ProductDetailRepositories productDetailRepositories = new ProductDetailRepositories();
    private final ProductRepositories productRepositories = new ProductRepositories();
    private final ColorRepositories colorRepositories = new ColorRepositories();
    private final SizeRepositories sizeRepositories = new SizeRepositories();
    private boolean showAlerts = false;
    private String message = "Changes saved";

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
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("store")) {
            this.store(req, resp);
        } else if (uri.contains("update")) {
            this.update(req, resp);
        }
    }

    @Override
    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductRepositories productRepositories = new ProductRepositories();
        ColorRepositories colorRepositories = new ColorRepositories();
        SizeRepositories sizeRepositories = new SizeRepositories();
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("VIEW", "/views/productDetails/index.jsp");
        req.setAttribute("TITLE", "PRODUCT DETAIL MANAGE");
        req.setAttribute("id", id);
        req.setAttribute("listColor", colorRepositories.findAll());
        req.setAttribute("listSize", sizeRepositories.findAll());
        req.setAttribute("products", productRepositories.findById(id).getListDetails());
        req.setAttribute("showAlerts", this.showAlerts);
        req.setAttribute("message", this.message);
        this.showAlerts = false;
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("VIEW", "/views/productDetails/index.jsp");
        req.setAttribute("TITLE", "PRODUCT DETAIL MANAGE");
        req.setAttribute("listProductDetails", this.productDetailRepositories.findAll());
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("VIEW", "/views/productDetails/create.jsp");
        req.setAttribute("TITLE", "ADD PRODUCT DETAIL");
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        SanPham sanPham = this.productRepositories.findById(Integer.parseInt(req.getParameter("id")));
        MauSac mauSac = this.colorRepositories.findById(Integer.parseInt(req.getParameter("mauSac")));
        Size size = this.sizeRepositories.findById(Integer.parseInt(req.getParameter("size")));
        Double giaBan = Double.valueOf(req.getParameter("giaBan"));
        Integer soLuongTon = Integer.valueOf(req.getParameter("soLuongTon"));
        String trangThai = req.getParameter("trangThai") != null ? "Activity" : "Inactive";
        Ctsp productDetail = new Ctsp();
        productDetail.setSanPham(sanPham);
        productDetail.setMauSac(mauSac);
        productDetail.setSize(size);
        productDetail.setGiaBan(giaBan);
        productDetail.setSoLuongTon(soLuongTon);
        productDetail.setTrangThai(trangThai);
        productDetail.setNgayTao(new Date());
        productDetail.setNgaySua(new Date());
        if (this.productDetailRepositories.save(productDetail)) {
            this.showAlerts = true;
            this.message = "A new product has been added";
            resp.sendRedirect("/product-detail/index?id=" + id);
        }
    }

    @Override
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("prd", this.productDetailRepositories.findById(Integer.parseInt(req.getParameter("id"))));
        req.setAttribute("VIEW", "/views/productDetails/edit.jsp");
        req.setAttribute("TITLE", "UPDATE PRODUCT");
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Ctsp prd = this.productDetailRepositories.findById(Integer.parseInt(req.getParameter("id")));
        prd.setNgaySua(new Date());
        prd.setGiaBan(Double.valueOf(req.getParameter("giaBan")));
        prd.setSoLuongTon(Integer.valueOf(req.getParameter("soLuongTon")));
        prd.setTrangThai(req.getParameter("trangThai") != null ? "Activity" : "Inactive");
        if (this.productDetailRepositories.update(prd)) {
            this.showAlerts = true;
            this.message = "Edited a product";
            resp.sendRedirect("/product-detail/index?id=" + prd.getSanPham().getId());
        }
    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}