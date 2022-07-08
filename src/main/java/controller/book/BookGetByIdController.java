package controller.book;

import helper.IntegerHelper;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/getById")
public class BookGetByIdController extends HttpServlet {
    private BookService bookService =new BookService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("book/getBookById.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("IdBook");
            boolean idBool = IntegerHelper.isDigit(id);
            if(!idBool)
                resp.getWriter().write("Please enter valid field for Cost");
            bookService.getById(Integer.parseInt(id));

        }catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }
}
