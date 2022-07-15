package controller.user;

import entity.Genre;
import entity.User;
import helper.Message;
import model.ResponseDto;
import service.GenreService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/search")
public class UserSearch extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String search = req.getParameter("search");
        ResponseDto<List<User>> responseDto = userService.getAllShowSearch(search);
        if (responseDto.isSuccess()) {
            req.setAttribute("users", responseDto.getData());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/userSearch.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            Message.print(req, resp, responseDto.getMessage());
        }
    }

}
