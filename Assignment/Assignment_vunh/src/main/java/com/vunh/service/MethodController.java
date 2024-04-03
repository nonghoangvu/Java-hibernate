package com.vunh.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface MethodController {
    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
