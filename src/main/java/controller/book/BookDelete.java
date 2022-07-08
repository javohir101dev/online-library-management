package controller.book;

import helper.IntegerHelper;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/delete")
public class BookDelete extends HttpServlet {
    private BookService bookService =new BookService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("book/deleteBook.jsp");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("IdBook");
            boolean idBool = IntegerHelper.isDigit(id);
            if(!idBool)
                resp.getWriter().write("Please enter valid field for Cost");
            bookService.delete(Integer.parseInt(id));

        }catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }
}
