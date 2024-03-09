package com.example.demohibernate.Controller;

import java.io.*;
import java.util.List;

import com.example.demohibernate.Model.Color;
import com.example.demohibernate.Service.ColorService;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "LoadColorServlet", value = "/color-manager")
public class LoadColor extends HttpServlet {
    private final ColorService colorService = new ColorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Color> color = this.colorService.getAllColor();
        req.setAttribute("listColor", color);
        req.getRequestDispatcher("Views/ColorManager.jsp").forward(req, resp);
        System.out.println("Run doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}