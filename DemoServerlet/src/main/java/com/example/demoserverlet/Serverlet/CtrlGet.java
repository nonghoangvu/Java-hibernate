package com.example.demoserverlet.Serverlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.example.demoserverlet.Model.NongHoangVu;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@WebServlet(name = "CtrlGetServlet", value = "/abc/trang-chu")
public class CtrlGet extends HttpServlet {
    private List<NongHoangVu> list;

    public CtrlGet() {
        this.list = new ArrayList<NongHoangVu>();
        this.list.add(new NongHoangVu("Nong Hoang Vu", 18, "IT"));
        this.list.add(new NongHoangVu("Nong Hoang A", 18, "IT"));
        this.list.add(new NongHoangVu("Nong Hoang B", 18, "IT"));
        this.list.add(new NongHoangVu("Nong Hoang C", 18, "IT"));
        this.list.add(new NongHoangVu("Nong Hoang D", 18, "IT"));
        this.list.add(new NongHoangVu("Nong Hoang E", 18, "IT"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Run doGet");
        req.setAttribute("value", this.list);
        req.getRequestDispatcher("/Views/HackerVu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String person = req.getParameter("person");
        String gender = req.getParameter("gender");
        req.setAttribute("value", this.list);
        req.setAttribute("person", String.format("Name: %s - Gender: %s", person, gender));
        req.getRequestDispatcher("/Views/HackerVu.jsp").forward(req, resp);
    }
}