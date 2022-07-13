package controller.user;

import helper.IntegerHelper;
import helper.Message;
import helper.StringHelper;
import model.ResponseDto;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/userDelete.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");

        if (StringHelper.isValid(username)) {
            ResponseDto responseDto = userService.deleteUserById(username);
            Message.print(req, resp, responseDto.getMessage());
        } else {
            Message.print(req, resp, "Please enter valid field for username");
        }
    }
}
