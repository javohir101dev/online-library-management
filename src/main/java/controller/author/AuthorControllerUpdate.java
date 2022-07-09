package controller.author;

import helper.DateHelper;
import helper.IntegerHelper;
import model.AuthorDto;
import service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/author/register")
public class AuthorControllerUpdate extends HttpServlet {
    private AuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("author/editAuthor.jsp");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("Id");
            String firstname = req.getParameter("firstName");
            String lastname = req.getParameter("lastName");
            String birthdate = req.getParameter("birthdate");

           if(! DateHelper.checkDate(birthdate))
               resp.getWriter().write("Please enter right birthdate");

           if(!IntegerHelper.isDigit(id))
               resp.getWriter().write("Please enter right id ");

            AuthorDto authorDto = AuthorDto.builder()
                    .id(Integer.parseInt(id))
                    .firstname(firstname)
                    .lastName(lastname)
                    .birthDate(Date.valueOf(birthdate))
                    .build();
            authorService.update(authorDto);
        }catch (Exception e)
        {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }
}
