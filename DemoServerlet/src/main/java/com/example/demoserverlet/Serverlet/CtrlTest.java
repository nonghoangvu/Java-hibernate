package com.example.demoserverlet.Serverlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.example.demoserverlet.Model.NongHoangVu;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "CtrlTestServlet", value = "/abc/validation")
public class CtrlTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean test = req.getParameter("firstName").length() > 1;
        req.setAttribute("lastName", test);
        req.getRequestDispatcher("/Views/HackerVu.jsp").forward(req, resp);
    }
}