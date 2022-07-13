package controller.book;

import model.BookDto;
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

@WebServlet("/book/getShow")
public class BookGetShow extends HttpServlet {

    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseDto<List<BookShow>> responseDto = bookService.getAllShow();
        if (responseDto.isSuccess()) {
            req.setAttribute("books", responseDto.getData());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book/getAllShow.jsp");
            requestDispatcher.forward(req,resp);
        }else {
            resp.getWriter().write(responseDto.getMessage());
        }
    }
}
