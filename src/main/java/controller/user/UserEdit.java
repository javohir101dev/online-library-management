package controller.user;

import entity.User;
import helper.IntegerHelper;
import helper.Message;
import model.BookDto;
import model.ResponseDto;
import model.UserUpdateDto;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static entity.enums.Roles.USER;
import static helper.messages.AppMessage.ERROR;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if (id == null || !IntegerHelper.isDigit(id)) {
                Message.print(req, resp, "Please enter valid Id");
            } else {
                ResponseDto<User> responseDto = userService.getById(Integer.parseInt(id));
                if (responseDto.isSuccess()) {

                    User user = responseDto.getData();
                    req.setAttribute("user", user);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/userEdit.jsp");
                    requestDispatcher.forward(req, resp);
                }
            }
        } catch (Exception e) {
            Message.print(req, resp, ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String firstname = req.getParameter("firstname");
            String lastName = req.getParameter("lastName");
            String username = req.getParameter("username");
            String phoneNumber = req.getParameter("phoneNumber");
            String password = req.getParameter("password");
//          if user registers it will be automatically registered with USER role
            UserUpdateDto user = new UserUpdateDto(id, firstname, lastName, username, phoneNumber, password);
            ResponseDto responseDto = userService.editUser(user);
            Message.print(req, resp, responseDto.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            Message.print(req, resp, "Please enter valid fields");
        }
    }
}
