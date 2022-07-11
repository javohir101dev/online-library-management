package controller.user;

import entity.User;
import model.ResponseDto;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static entity.enums.Roles.ADMIN;
import static entity.enums.Roles.USER;

@WebServlet("/user/addAdmin")
public class AddAdmin extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/user/addAdmin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            String firstname = req.getParameter("firstname");
            String lastName = req.getParameter("lastName");
            String username = req.getParameter("username");
            String phoneNumber = req.getParameter("phoneNumber");
            String password = req.getParameter("password");
//          if user registers it will be automatically registered with ADMIN role
            User user = new User(firstname, lastName, username, phoneNumber, password, ADMIN.name());
            ResponseDto responseDto = userService.registerUser(user);
            writer.write(responseDto.getMessage());
        } catch (Exception e) {
            writer.write("Please enter valid fields");
        }
    }
}
