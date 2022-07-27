package controller.book;

import helper.Message;
import model.BookDto;
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

@WebServlet("/book/getAll")
public class BookGetAll extends HttpServlet {
    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseDto<List<BookDto>> responseDto = bookService.getAll();
        if (responseDto.isSuccess()) {
            req.setAttribute("books", responseDto.getData());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("bookGetAll.jsp");
            requestDispatcher.forward(req,resp);
        }else {
            Message.print(req, resp,responseDto.getMessage());
        }
    }
}