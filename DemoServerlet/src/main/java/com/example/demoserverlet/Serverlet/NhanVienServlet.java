package com.example.demoserverlet.Serverlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.example.demoserverlet.Model.NongHoangVu;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "NhanVienServletServlet", value = "/home")
public class NhanVienServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NongHoangVu> vuList = new ArrayList<>();
        vuList.add(new NongHoangVu("Vu", 19, "IT"));
        vuList.add(new NongHoangVu("A", 19, "HR"));
        req.setAttribute("listVu", vuList);
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