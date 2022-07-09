package controller.author;

import helper.DateHelper;
import helper.IntegerHelper;
import helper.messages.AppMessage;
import model.AuthorDto;
import model.ResponseDto;
import service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import static helper.messages.AppMessage.ERROR;

@WebServlet("/author/edit")
public class AuthorEditController extends HttpServlet {
    private AuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/author/editAuthor.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            String id = req.getParameter("id");
            String firstname = req.getParameter("firstName");
            String lastname = req.getParameter("lastName");
            String birthDate = req.getParameter("birthDate");

            if (id == null || !IntegerHelper.isDigit(id)) {
                writer.write("Please enter valid Id");
            } else if (firstname == null) {
                writer.write("Please enter valid First Name");
            } else if (lastname == null) {
                writer.write("Please enter valid Last Name");
            } else if (birthDate == null || !DateHelper.checkDate(birthDate)) {
                writer.write("Please enter valid birthDate");
            } else {
                AuthorDto authorDto = AuthorDto.builder()
                        .id(Integer.parseInt(id))
                        .firstname(firstname)
                        .lastName(lastname)
                        .birthDate(Date.valueOf(birthDate))
                        .build();
                ResponseDto<AuthorDto> responseDto = authorService.update(authorDto);
                    writer.write(responseDto.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            writer.write(ERROR);
        }
    }
}
