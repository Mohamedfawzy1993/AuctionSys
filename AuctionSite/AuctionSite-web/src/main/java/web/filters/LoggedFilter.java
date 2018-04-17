package web.filters;

import web.LoginBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "loggedFilter",
        urlPatterns = {"/faces/home.xhtml" , "/faces/createAuction.xhtml" ,"/faces/adminReport.xhtml"})
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
            
            if(loginBean.getUser().getRole().equals("Seller")){
                httpServletResponse.sendRedirect("/faces/adminReport.xhtml");
            }else{
                System.out.println("Not Logged");
                filterChain.doFilter(servletRequest , servletResponse);
            }
        }
        else {
            httpServletResponse.sendRedirect("login.xhtml");
        }

    }

    @Override
    public void destroy() {

    }
}
