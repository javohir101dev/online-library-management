package controller.author;

import helper.IntegerHelper;
import service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/author/delete")
public class AuthorDelete extends HttpServlet {
    private AuthorService authorService =new AuthorService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("author/deleteAuthor.jsp");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("IdAuthor");
            boolean idBool = IntegerHelper.isDigit(id);
            if(!idBool)
                resp.getWriter().write("Please enter valid field for id");
            authorService.delete(Integer.parseInt(id));

        }catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }
}
