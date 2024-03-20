package com.vunh.loginfilter.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "JPSCheck", urlPatterns = "/*")
public class JPSCheck implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String uri = req.getRequestURI();
        if (uri.contains(".jsp")) {
            if (session.getAttribute("login-success") != null) {
                resp.sendRedirect("home");
            } else {
                resp.sendRedirect("login");
            }
        }
        chain.doFilter(request, response);
    }
}
 
