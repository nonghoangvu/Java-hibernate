package com.example.demoserverlet.Serverlet;

import java.io.*;

import com.example.demoserverlet.Model.NongHoangVu;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "NhanVienServletServlet", value = "/home")
public class NhanVienServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NongHoangVu nv = new NongHoangVu("Nong Hoang Vu", 18, "IT");
        req.setAttribute("value", nv);
        req.getRequestDispatcher("/homePage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var myName = req.getParameter("myName");
        NongHoangVu nv = new NongHoangVu("Nong Hoang Vu", 18, "IT");
        nv.setFullName(myName);
        req.setAttribute("value", nv);
        req.getRequestDispatcher("/homePage.jsp").forward(req, resp);
    }
}