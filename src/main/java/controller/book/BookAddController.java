package controller.book;

import model.BookDto;
import model.ResponseDto;
import service.BookService;

import static helper.IntegerHelper.*;
import static helper.DoubleHelper.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/add")
public class BookAddController extends HttpServlet {

    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/book/addBook.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String bookName = req.getParameter("NameBook");
            String cost = req.getParameter("Cost");
            String genre = req.getParameter("genre");
            String pageCount = req.getParameter("PageCount");
            String totalNumberOfBooks = req.getParameter("TotalCount");
            String authorId = req.getParameter("AuthorId");

            boolean costBol = checkDouble(cost);
            boolean total = isDigit(totalNumberOfBooks);
            boolean pageCountBol = isDigit(pageCount);
            boolean authorIdBol = isDigit(authorId);
            if (!total) {
                resp.getWriter().write("Please enter valid field for Number of Books");
            } else if (!pageCountBol) {
                resp.getWriter().write("Please enter valid field for Page Count");
            } else if (!authorIdBol) {
                resp.getWriter().write("Please enter valid field for Author Id");
            } else if (!costBol) {
                resp.getWriter().write("Please enter valid field for Cost");
                resp.setStatus(400, "BAD REQUEST");
            } else {
                BookDto bookDto = BookDto.builder()
                        .name(bookName)
                        .cost(Double.parseDouble(cost))
                        .genre(genre)
                        .pageCount(Integer.parseInt(pageCount))
                        .totalNumberOfBooks(Integer.parseInt(totalNumberOfBooks))
                        .authorId(Integer.parseInt(authorId))
                        .build();
                ResponseDto<BookDto> responseDto = bookService.addBook(bookDto);
                resp.getWriter().write(responseDto.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }
}
