package controller.user;

import entity.User;
import entity.enums.Roles;
import model.LoginUserDto;
import model.ResponseDto;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static entity.enums.Roles.ADMIN;
import static entity.enums.Roles.USER;

@WebServlet("/user/login")
public class UserLogin extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            LoginUserDto loginUserDto = new LoginUserDto(username, password);
            ResponseDto responseDto = userService.loginService(loginUserDto);
            if (!responseDto.isSuccess()){
                resp.getWriter().write(responseDto.getMessage());
            }else{
               User user =  (User) responseDto.getData();
                req.setAttribute("user", user);
               if (user.getRole().equals(USER.name())){
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("cabinet.jsp");
                   requestDispatcher.forward(req, resp);
               }else if (user.getRole().equals(ADMIN.   name())){
                   req.setAttribute("user", user);
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("cabinetAdmin.jsp");
                   requestDispatcher.forward(req, resp);
               }else {
                   resp.getWriter().write("Something is wrong");
               }
            }
        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().write("Please enter walid username or password");
        }
    }
}
