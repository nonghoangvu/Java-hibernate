package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebFilter(filterName = "filter1", urlPatterns = "/admin", dispatcherTypes = DispatcherType.REQUEST)
public class NHVFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
//        String uri = req.getServletPath();
//        System.out.println("Run filter admin");
//        if (uri.contains("Admin.jsp")) {
//            req.getRequestDispatcher("/Views/Admin.jsp").forward(req, resp);
//        } else {
//            req.getRequestDispatcher("/Views/Home.jsp").forward(req, resp);
//        }
        System.out.println("Run filter admin");
        chain.doFilter(request, response);
    }
}
 
