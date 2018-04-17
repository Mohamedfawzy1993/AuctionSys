package web.filters;

import web.LoginBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "loggedFilter",
        urlPatterns = {"/faces/userAuctions.xhtml" , "/faces/productDetails.xhtml" ,"/faces/joinedAuctions.xhtml" , "/faces/createAuction.xhtml"})
public class LoggedFilter implements Filter {

    @Inject
    private LoginBean loginBean;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        System.out.println("In Filter");
        if(loginBean != null && loginBean.getUser() != null){
            System.out.println("Not Logged");
            filterChain.doFilter(servletRequest , servletResponse);
        }
        else {
            httpServletResponse.sendRedirect("login.xhtml");
        }

    }

    @Override
    public void destroy() {

    }
}
