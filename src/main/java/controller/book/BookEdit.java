package controller.book;

import helper.IntegerHelper;
import helper.Message;
import helper.messages.AppMessage;
import model.AuthorDto;
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

import static helper.DoubleHelper.checkDouble;
import static helper.IntegerHelper.isDigit;
import static helper.messages.AppMessage.ERROR;

@WebServlet("/book/edit")
public class BookEdit extends HttpServlet {
    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if (id == null || !IntegerHelper.isDigit(id)) {
                Message.print(req, resp, "Please enter valid Id");
            } else {
                ResponseDto<BookDto> responseDto = bookService.getById(Integer.parseInt(id));
                if (responseDto.isSuccess()) {

                    BookDto bookDto = responseDto.getData();
                    req.setAttribute("book", bookDto);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book/editBook.jsp");
                    requestDispatcher.forward(req, resp);
                }
            }
        } catch (Exception e) {
            Message.print(req, resp, ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            String id = req.getParameter("IdBook");
            String bookName = req.getParameter("NameBook");
            String cost = req.getParameter("Cost");
            String genreId = req.getParameter("genreId");
            String pageCount = req.getParameter("PageCount");
            String totalNumberOfBooks = req.getParameter("TotalCount");
            String leftCount = req.getParameter("leftCount");
            String authorId = req.getParameter("AuthorId");

            boolean costBol = checkDouble(cost);
            boolean total = isDigit(totalNumberOfBooks);
            boolean genreIdValid = isDigit(genreId);
            boolean leftCountValid = isDigit(leftCount);
            boolean pageCountBol = isDigit(pageCount);
            boolean authorIdBol = isDigit(authorId);
            boolean idBool = isDigit(id);
            if (!genreIdValid) {
                Message.print(req, resp, "Please enter valid field for Genre id");
            } else if (!idBool) {
                Message.print(req, resp, "Please enter valid field for Book id");
            } else if (!total) {
                Message.print(req, resp, "Please enter valid field for Total Number of Books");
            } else if (!leftCountValid) {
                Message.print(req, resp, "Please enter valid field for Left Number of Books");
            } else if (!pageCountBol) {
                Message.print(req, resp, "Please enter valid field for Page Count");
            } else if (!authorIdBol) {
                Message.print(req, resp, "Please enter valid field for Author Id");
            } else if (!costBol) {
                Message.print(req, resp, "Please enter valid field for Cost");
                resp.sendError(400, "BAD REQUEST");
            } else {
                BookDto bookDto = BookDto.builder()
                        .id(Integer.parseInt(id))
                        .name(bookName)
                        .cost(Double.parseDouble(cost))
                        .genreId(Integer.parseInt(genreId))
                        .pageCount(Integer.parseInt(pageCount))
                        .totalNumberOfBooks(Integer.parseInt(totalNumberOfBooks))
                        .leftNumberOfBooks(Integer.parseInt(leftCount))
                        .authorId(Integer.parseInt(authorId))
                        .build();
                ResponseDto<BookDto> responseDto = bookService.update(bookDto);
                Message.print(req, resp, responseDto.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Message.print(req, resp, ERROR);
        }
    }
}
