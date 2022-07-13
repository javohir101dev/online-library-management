package controller.user;


import entity.User;
import helper.Message;
import model.ResponseDto;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/getAll")
public class UserGetAll extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseDto<List<User>> responseDto = userService.getAllUsers();
        if (responseDto.isSuccess()) {
            req.setAttribute("users", responseDto.getData());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/getAll.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            Message.print(req, resp, responseDto.getMessage());
        }
    }
}
