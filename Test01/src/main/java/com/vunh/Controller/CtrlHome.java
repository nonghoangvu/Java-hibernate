package com.vunh.Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.vunh.Model.NhanVien;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.tags.shaded.org.apache.bcel.generic.FADD;

@WebServlet(name = "CtrlHomeServlet", value = {"/home", "/add", "/detail/*", "/delete/*", "/update"})
public class CtrlHome extends HttpServlet {
    private List<NhanVien> list;

    public CtrlHome() {
        this.list = new ArrayList<>();
        this.list.add(new NhanVien("NV001", "Nguyễn Văn A", "HN", 30, "Phòng A", true));
        this.list.add(new NhanVien("NV002", "Nguyễn Văn B", "HN", 30, "Phòng A", true));
        this.list.add(new NhanVien("NV003", "Nguyễn Văn C", "HN", 30, "Phòng A", true));
        this.list.add(new NhanVien("NV004", "Nguyễn Thi D", "HN", 30, "Phòng A", false));
        this.list.add(new NhanVien("NV005", "Nguyễn Văn E", "HN", 30, "Phòng A", true));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().contains("home")) {
            req.setAttribute("ListNhanVien", this.list);
            req.getRequestDispatcher("/Views/Home.jsp").forward(req, resp);
        } else if (req.getRequestURI().contains("detail")) {
            detail(req, resp);
        } else if (req.getRequestURI().contains("delete")) {
            delete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().contains("add")) {
            add(req, resp);
        } else if (req.getRequestURI().contains("update")) {
            update(req, resp);
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            NhanVien nhanVien = new NhanVien();
            BeanUtils.populate(nhanVien, req.getParameterMap());
            this.list.add(nhanVien);
            resp.sendRedirect("/home");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NhanVien nhanVien = this.list.stream().filter(s -> s.getMaNhanVien().equals(req.getParameter("id"))).collect(Collectors.toList()).get(0);
        req.setAttribute("NhanVien", nhanVien);
        req.getRequestDispatcher("/Views/Detail.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.list.remove(Integer.parseInt(req.getParameter("index")));
        resp.sendRedirect("/home");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("Update");
            NhanVien nhanVien = new NhanVien();
            BeanUtils.populate(nhanVien, req.getParameterMap());
            this.list.stream().filter(nhanVien1 -> nhanVien1.getMaNhanVien().equals(nhanVien.getMaNhanVien())).collect(Collectors.toList()).forEach(s -> {
                s.setTenNhanVien(nhanVien.getTenNhanVien());
                s.setDiaChi(nhanVien.getDiaChi());
                s.setTuoi(nhanVien.getTuoi());
                s.setPhongBan(nhanVien.getPhongBan());
                s.setGioiTinh(nhanVien.isGioiTinh());
                System.out.println(s.getTenNhanVien());
            });

            resp.sendRedirect("/home");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}