package com.vunh.Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/index.jsp","/admin/add", "/admin/update", "/admin/delete/*", "/admin/detail/*"})
public class LoginFilter implements Filter {
    public static String first = "bm9uZ2hvYW5ndnVAZ21haWwuY29t";
    public static String second = "MTIz";
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null){
            resp.sendRedirect("/login");
        }
        chain.doFilter(request, response);
    }
}
 
