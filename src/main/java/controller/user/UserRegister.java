package controller.user;

import entity.User;
import entity.enums.Roles;
import model.ResponseDto;
import repository.UserRepository;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static entity.enums.Roles.USER;

@WebServlet("/user/register")
public class UserRegister extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String firstname = req.getParameter("firstname");
            String lastName = req.getParameter("lastName");
            String username = req.getParameter("username");
            String phoneNumber = req.getParameter("phoneNumber");
            String password = req.getParameter("password");
            Double account = Double.valueOf(req.getParameter("account"));
//          if user registers it will be automatically registered with USER role
            User user = new User(firstname, lastName, username, phoneNumber, password, account, USER.name());
            ResponseDto responseDto = userService.registerUser(user);
            if (responseDto.isSuccess()) {
                resp.sendRedirect("/user/login");
            }

        } catch (Exception e) {
            resp.getWriter().write("Please enter valid fields");
        }


    }
}
