package com.vunh.hibernateclass.controller;

import java.io.*;

import com.vunh.hibernateclass.reponsitories.SizeResp;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "SizeServletServlet", value = {"/index"})
public class SizeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSize", new SizeResp().findAll());
        req.getRequestDispatcher("/SizeForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}