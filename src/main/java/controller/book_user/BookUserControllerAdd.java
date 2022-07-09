package controller.book_user;

import model.BookUserDto;
import model.ResponseDto;
import service.BookUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book-user/add")
public class BookUserControllerAdd extends HttpServlet {
    BookUserService service = new BookUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("addBookToUser.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            Integer bookId = Integer.valueOf(req.getParameter("bookId"));
            Integer numberOfBooks = Integer.valueOf(req.getParameter("numberOfBooks"));
            BookUserDto dto = new BookUserDto(username, bookId, numberOfBooks);
            ResponseDto responseDto = service.addBookToUser(dto);
            resp.getWriter().write(responseDto.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Please enter valid fields" + e.getMessage());
        }
    }
}