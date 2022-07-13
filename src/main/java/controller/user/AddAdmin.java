package controller.user;

import helper.Message;
import security.Security;
import entity.User;
import model.ResponseDto;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import static entity.enums.Roles.ADMIN;

@WebServlet("/user/addAdmin")
public class AddAdmin extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean hasPermission =
                Security.hasPermission(req);

        if (!hasPermission) {
            resp.sendRedirect("/user/login");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/addAdmin.jsp");
            requestDispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        boolean hasPermission = Security.hasPermission(req);

        if (!hasPermission) {
            resp.sendRedirect("/user/login");
        }else {
            try {
                String firstname = req.getParameter("firstname");
                String lastName = req.getParameter("lastName");
                String username = req.getParameter("username");
                String phoneNumber = req.getParameter("phoneNumber");
                String password = req.getParameter("password");
//          if user registers it will be automatically registered with ADMIN role
                User user = new User(firstname, lastName, username, phoneNumber, password, ADMIN.name());
                ResponseDto responseDto = userService.registerUser(user);
                Message.print(req, resp, responseDto.getMessage());
            } catch (Exception e) {
                Message.print(req, resp,"Please enter valid fields");
            }
        }
    }
}
