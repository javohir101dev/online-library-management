package controller.book;

import helper.Message;
import model.BookShow;
import model.ResponseDto;
import service.BookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book/search")
public class BookShowSearch extends HttpServlet {

    BookService bookService = new BookService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String search = req.getParameter("search");
        ResponseDto<List<BookShow>> responseDto = bookService.getAllShowSearch(search);
        if (responseDto.isSuccess()) {
            req.setAttribute("books", responseDto.getData());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book/showAllSearch.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            Message.print(req, resp, responseDto.getMessage());
        }
    }
}
