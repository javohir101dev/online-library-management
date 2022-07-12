package controller.user;

import helper.messages.AppMessage;
import security.Security;
import entity.User;
import model.LoginUserDto;
import model.ResponseDto;
import model.UsersBook;
import repository.BookRepository;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

import static entity.enums.Roles.ADMIN;
import static entity.enums.Roles.USER;
import static helper.messages.AppMessage.ERROR;

@WebServlet("/user/login")
public class UserLogin extends HttpServlet {

    private UserService userService = new UserService();
    private BookRepository bookRepository = new BookRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/user/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            LoginUserDto loginUserDto = new LoginUserDto(username, password);
            ResponseDto responseDto = userService.loginService(loginUserDto);
            if (!responseDto.isSuccess()) {
                resp.getWriter().write(responseDto.getMessage());
            } else {

//               Adding security with cookie and session
                Security.addCookieAndSession(req, resp, username);

                User user = (User) responseDto.getData();
                req.setAttribute("user", user);
                List<UsersBook> bookList = bookRepository.usersBooksByUserId(user.getId());
                req.setAttribute("books", bookList);
                if (user.getRole().equals(USER.name())) {
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/cabinet");
                    requestDispatcher.forward(req, resp);
                } else if (user.getRole().equals(ADMIN.name())) {
                    req.setAttribute("user", user);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/cabinetAdmin");
                    requestDispatcher.forward(req, resp);
                } else {
                    resp.getWriter().write(ERROR);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Please enter valid username or password");
        }
    }
}
