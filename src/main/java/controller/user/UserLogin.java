package controller.user;

import helper.Message;
import repository.BookRepository;
import security.Security;
import entity.User;
import model.LoginUserDto;
import model.ResponseDto;
import model.UsersBook;
import repository.impl.BookRepositoryImpl;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static entity.enums.Roles.ADMIN;
import static entity.enums.Roles.USER;
import static helper.messages.AppMessage.ERROR;

@WebServlet("/user/login")
public class UserLogin extends HttpServlet {

    private UserService userService = new UserService();
    private BookRepository bookRepository = BookRepositoryImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            LoginUserDto loginUserDto = new LoginUserDto(username, password);
            ResponseDto responseDto = userService.loginService(loginUserDto);
            if (!responseDto.isSuccess()) {
                Message.print(req, resp, responseDto.getMessage());
            } else {

//               Adding security with cookie and session
                Security.addCookieAndSession(req, resp, username);

                User user = (User) responseDto.getData();
                req.setAttribute("user", user);
                if (user.getRole().equals(USER.name())) {
                List<UsersBook> bookList = bookRepository.usersBooksByUserId(user.getId());
                req.setAttribute("books", bookList);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/cabinet");
//                    resp.sendRedirect("/user/cabinet");
                    requestDispatcher.forward(req, resp);
                } else if (user.getRole().equals(ADMIN.name())) {
                    req.setAttribute("user", user);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/cabinetAdmin");
                    requestDispatcher.forward(req, resp);
                } else {
                    Message.print(req, resp, ERROR);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Message.print(req, resp, "Please enter valid username or password");
        }
    }
}
