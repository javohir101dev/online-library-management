package controller.book;

import helper.IntegerHelper;
import helper.Message;
import helper.messages.AppMessage;
import model.ResponseDto;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static helper.messages.AppMessage.ERROR;

@WebServlet("/book/delete")
public class BookDelete extends HttpServlet {
    private BookService bookService =new BookService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/book/deleteBook.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("IdBook");
            boolean idBool = IntegerHelper.isDigit(id);
            if(!idBool)
                Message.print(req, resp,"Please enter valid field for Book Id");
            ResponseDto<?> responseDto = bookService.delete(Integer.parseInt(id));
            Message.print(req, resp,responseDto.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            Message.print(req, resp,ERROR);
        }
    }
}
