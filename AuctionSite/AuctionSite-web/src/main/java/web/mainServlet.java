package web;


import controller.beans.TestBean;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;


@WebServlet(urlPatterns = "/servlet")
public class mainServlet extends HttpServlet {

    @EJB
    private TestBean testBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        User user = testBean.getUser();
//        resp.getWriter().println(user == null ? "Not Found" : user.getEmail());

        testBean.dollarToYen(new BigDecimal("100"));
        System.out.println("Persisted");
    }
}
