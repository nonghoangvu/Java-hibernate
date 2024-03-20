package com.vunh.uploadfile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

@MultipartConfig()
@WebServlet(name = "CtrlUploadServlet", value = "/upload")
public class CtrlUpload extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            Part part = req.getPart("photo");

            String realPath = req.getServletContext().getRealPath("/images");
            String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Path.of(realPath))) {
                Files.createDirectories(Path.of(realPath));
            }
            part.write(realPath + "/" + filename);
            System.out.println(realPath);
            req.setAttribute("url", "images/" + filename);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        req.getRequestDispatcher("/Info.jsp").forward(req, resp);
    }
}