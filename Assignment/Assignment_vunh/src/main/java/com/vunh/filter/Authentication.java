package com.vunh.filter;

import com.vunh.entities.Account;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "Authentication", urlPatterns = {
        "/category/show", "/category/create", "/category/store", "/category/edit", "/category/update", "/category/delete",
        "/color/show", "/color/create", "/color/store", "/color/edit", "/color/update", "/color/delete",
        "/product/show", "/product/create", "/product/store", "/product/edit", "/product/update", "/product/delete",
        "/size/show", "/size/create", "/size/store", "/size/edit", "/size/update", "/size/delete",
        "/product-detail/show", "/product-detail/create", "/product-detail/store", "/product-detail/edit", "/product-detail/update", "/product-detail/delete"
})
public class Authentication implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        try {
            HttpSession session = req.getSession();
            Account account = (Account) session.getAttribute("user");
            if (!account.getRole()) {
                req.getRequestDispatcher("/template/Error.jsp").forward(req, resp);
                return;
            }
        } catch (Exception e) {
            req.getRequestDispatcher("/template/Error.jsp").forward(req, resp);
        }

        chain.doFilter(request, response);
    }
}
 
