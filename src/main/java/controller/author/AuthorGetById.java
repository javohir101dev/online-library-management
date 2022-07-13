package controller.author;

import helper.IntegerHelper;
import helper.Message;
import security.Security;
import service.AuthorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/author/findById")
public class AuthorGetById extends HttpServlet {
    private AuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Security.hasPermission(req)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("author/getAllAuthors.jsp");
                    requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/user/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("IdAuthor");
            boolean idBool = IntegerHelper.isDigit(id);
            if (!idBool)
                resp.getWriter().write("Please enter valid field for id");
            authorService.delete(Integer.parseInt(id));

        } catch (Exception e) {
            e.printStackTrace();
            Message.print(req, resp,"Error");
        }
    }
}
