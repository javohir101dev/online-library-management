package controller.author;

import helper.DateHelper;
import model.AuthorDto;
import service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/author")
public class AuthorController extends HttpServlet {
    private AuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("author/addAuthor.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String firstname = req.getParameter("firstName");
            String lastname = req.getParameter("lastName");
            String birthdate = req.getParameter("birthdate");

            if (!DateHelper.checkDate(birthdate))
                resp.getWriter().write("Please enter right birthdate");

            AuthorDto authorDto = AuthorDto.builder()
                    .firstname(firstname)
                    .lastName(lastname)
                    .birthDate(Date.valueOf(birthdate))
                    .build();
            authorService.update(authorDto);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }
}
