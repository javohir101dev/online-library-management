package controller.book_user;

import helper.Message;
import model.BookUserAll;
import model.ResponseDto;
import service.BookUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book-user/search")
public class BookUserSearch extends HttpServlet {

    BookUserService bookUserService = new BookUserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        ResponseDto<List<BookUserAll>> responseDto = bookUserService.getAllBookUserAllSearch(search);
        if (responseDto.isSuccess()) {
            req.setAttribute("bookUsers", responseDto.getData());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book-user/bookUserSearch.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            Message.print(req, resp, responseDto.getMessage());
        }
    }

}
