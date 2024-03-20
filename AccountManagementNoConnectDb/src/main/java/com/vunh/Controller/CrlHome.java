package com.vunh.Controller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.vunh.Model.Account;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "CrlHomeServlet", value = {"/admin/home", "/admin/add", "/admin/update", "/admin/delete/*", "/admin/detail/*", "/logout"})
public class CrlHome extends HttpServlet {
    private List<Account> listAccounts;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public CrlHome() {
        this.listAccounts = new ArrayList<>();
        this.listAccounts.add(new Account(20041201, "Nong Hoang Vu", true, LocalDate.of(2004, 12, 1), "VietNam"));
        this.listAccounts.add(new Account(2342, "Nguyen Van A", true, LocalDate.of(2003, 1, 3), "VietNam"));
        this.listAccounts.add(new Account(2325, "Nguyen Thi B", false, LocalDate.of(2002, 2, 6), "VietNam"));
        this.listAccounts.add(new Account(3545, "Nguyen Van C", true, LocalDate.of(2006, 11, 11), "VietNam"));
        this.listAccounts.add(new Account(82335, "Nguyen Thi D", false, LocalDate.of(2004, 12, 21), "VietNam"));
        this.listAccounts.add(new Account(1111, "Nguyen Van E", true, LocalDate.of(2003, 10, 1), "VietNam"));
        this.listAccounts.add(new Account(8221, "Nguyen Thi G", false, LocalDate.of(2010, 9, 11), "VietNam"));
        this.listAccounts.add(new Account(24235, "Nguyen Van H", true, LocalDate.of(2007, 12, 21), "VietNam"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!resp.isCommitted()) {
            if (req.getRequestURI().contains("delete")) {
                delete(req, resp);
            } else if (req.getRequestURI().contains("detail")) {
                detail(req, resp);
            } else if (req.getRequestURI().contains("logout")) {
                HttpSession session = req.getSession();
                session.removeAttribute("user");
                resp.sendRedirect("/login");
            } else {
                loadForm(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!resp.isCommitted()) {
            if (req.getRequestURI().contains("add")) {
                add(req, resp);
            } else if (req.getRequestURI().contains("update")) {
                update(req, resp);
            }
        }
    }

    private void loadForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> countryList = Arrays.asList("United States", "United Kingdom", "VietNam", "Australia");
        req.setAttribute("countryList", countryList);
        req.setAttribute("Accounts", this.listAccounts);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String fullName = req.getParameter("fullName");
        boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        String country = req.getParameter("country");
        this.listAccounts.add(new Account(id, fullName, gender, dateOfBirth, country));
        resp.sendRedirect("/admin/home");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String fullName = req.getParameter("fullName");
        boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        String country = req.getParameter("country");
        this.listAccounts.stream().filter(a -> a.getId() == id).forEach(a -> {
            a.setFullName(fullName);
            a.setGender(gender);
            a.setDateOfBirth(dateOfBirth);
            a.setCountry(country);
        });
        resp.sendRedirect("/admin/home");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.listAccounts.remove(Integer.parseInt(req.getParameter("index")));
        resp.sendRedirect("/admin/home");
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = this.listAccounts.get(Integer.parseInt(req.getParameter("index")));
        List<String> countryList = Arrays.asList("United States", "United Kingdom", "VietNam", "Australia");
        req.setAttribute("countryList", countryList);
        req.setAttribute("Account", account);
        req.getRequestDispatcher("/Views/Detail.jsp").forward(req, resp);

    }
}