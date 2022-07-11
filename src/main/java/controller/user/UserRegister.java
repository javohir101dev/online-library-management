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

import static entity.enums.Roles.USER;

@WebServlet("/user/register")
public class UserRegister extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            String firstname = req.getParameter("firstname");
            String lastName = req.getParameter("lastName");
            String username = req.getParameter("username");
            String phoneNumber = req.getParameter("phoneNumber");
            String password = req.getParameter("password");
//          if user registers it will be automatically registered with USER role
            User user = new User(firstname, lastName, username, phoneNumber, password, USER.name());
            ResponseDto responseDto = userService.registerUser(user);
            if (responseDto.isSuccess()) {
                resp.sendRedirect("/user/login");
            } else {
                writer.write(responseDto.getMessage());
            }
        } catch (Exception e) {
            writer.write("Please enter valid fields");
        }
    }
}
