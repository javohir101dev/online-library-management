package controller.user;

import entity.User;
import model.ResponseDto;
import model.UserUpdateDto;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static entity.enums.Roles.USER;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            String firstname = req.getParameter("firstname");
            String lastName = req.getParameter("lastName");
            String oldUsername = req.getParameter("oldUsername");
            String newUsername = req.getParameter("newUsername");
            String phoneNumber = req.getParameter("phoneNumber");
            String password = req.getParameter("password");
//          if user registers it will be automatically registered with USER role
            UserUpdateDto user = new UserUpdateDto(firstname, lastName, oldUsername, newUsername, phoneNumber, password);
            ResponseDto responseDto = userService.editUser(user);
            writer.write(responseDto.getMessage());
        } catch (Exception e) {
            writer.write("Please enter valid fields");
        }
    }
}
