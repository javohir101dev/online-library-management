package controller.book;

import model.BookDto;
import model.ResponseDto;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static helper.DoubleHelper.checkDouble;
import static helper.IntegerHelper.isDigit;

@WebServlet("/book/edit")
public class BookControllerEdit extends HttpServlet {
    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/book/editBook.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String id = req.getParameter("IdBook");
            String bookName = req.getParameter("NameBook");
            String cost = req.getParameter("Cost");
            String genre = req.getParameter("genre");
            String pageCount = req.getParameter("PageCount");
            String totalNumberOfBooks = req.getParameter("TotalCount");
            String leftCount = req.getParameter("leftCount");
            String authorId = req.getParameter("AuthorId");

            boolean costBol = checkDouble(cost);
            boolean total = isDigit(totalNumberOfBooks);
            boolean leftCountValid = isDigit(leftCount);
            boolean pageCountBol = isDigit(pageCount);
            boolean authorIdBol = isDigit(authorId);
            boolean idBool = isDigit(id);
            if (!idBool) {
                resp.getWriter().write("Please enter valid field for Book id");
            } else if (!total) {
                resp.getWriter().write("Please enter valid field for Total Number of Books");
            } else if (!leftCountValid) {
                resp.getWriter().write("Please enter valid field for Left Number of Books");
            } else if (!pageCountBol) {
                resp.getWriter().write("Please enter valid field for Page Count");
            } else if (!authorIdBol) {
                resp.getWriter().write("Please enter valid field for Author Id");
            } else if (!costBol) {
                resp.getWriter().write("Please enter valid field for Cost");
                resp.sendError(400, "BAD REQUEST");
            } else {
                BookDto bookDto = BookDto.builder()
                        .id(Integer.parseInt(id))
                        .name(bookName)
                        .cost(Double.parseDouble(cost))
                        .genre(genre)
                        .pageCount(Integer.parseInt(pageCount))
                        .totalNumberOfBooks(Integer.parseInt(totalNumberOfBooks))
                        .leftNumberOfBooks(Integer.parseInt(leftCount))
                        .authorId(Integer.parseInt(authorId))
                        .build();
                ResponseDto<BookDto> responseDto = bookService.update(bookDto);
                resp.getWriter().write(responseDto.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Something went wrong. Please try again!");
        }
    }
}
