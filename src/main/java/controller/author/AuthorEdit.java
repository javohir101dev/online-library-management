package controller.author;

import helper.DateHelper;
import helper.IntegerHelper;
import helper.Message;
import helper.messages.AppMessage;
import model.AuthorDto;
import model.ResponseDto;
import repository.AuthorRepository;
import repository.impl.AuthorRepositoryImpl;
import security.Security;
import service.AuthorService;

import javax.servlet.RequestDispatcher;
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
public class AuthorEdit extends HttpServlet {
    private AuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String id = req.getParameter("id");
            if (id == null || !IntegerHelper.isDigit(id)) {
                Message.print(req, resp, "Please enter valid Id");
            } else {
                ResponseDto<AuthorDto> responseDto = authorService.getById(Integer.parseInt(id));
                if (responseDto.isSuccess()) {

                    AuthorDto authorDto = responseDto.getData();
                    req.setAttribute("author", authorDto);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/author/editAuthor.jsp");
                    requestDispatcher.forward(req, resp);
                }
            }
        } catch (Exception e) {
            Message.print(req, resp, ERROR);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String firstname = req.getParameter("firstName");
            String lastname = req.getParameter("lastName");
            String birthDate = req.getParameter("birthDate");
            req.getParameter("authorId");

            if (id == null || !IntegerHelper.isDigit(id)) {
                Message.print(req, resp, "Please enter valid Id");
            } else if (firstname == null) {
                Message.print(req, resp, "Please enter valid First Name");
            } else if (lastname == null) {
                Message.print(req, resp, "Please enter valid Last Name");
            } else if (birthDate == null || !DateHelper.checkDate(birthDate)) {
                Message.print(req, resp, "Please enter valid birthDate");
            } else {
                AuthorDto authorDto = AuthorDto.builder()
                        .id(Integer.parseInt(id))
                        .firstname(firstname)
                        .lastName(lastname)
                        .birthDate(Date.valueOf(birthDate))
                        .build();
                ResponseDto<AuthorDto> responseDto = authorService.update(authorDto);
                Message.print(req, resp, responseDto.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Message.print(req, resp, ERROR);
        }
    }
}
