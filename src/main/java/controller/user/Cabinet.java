package controller.user;

import security.Security;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/cabinet")
public class Cabinet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean hasPermission = Security.hasPermission(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean hasPermission = Security.hasPermission(req);
        if (hasPermission) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/cabinet.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/user/login");
        }

    }
}
