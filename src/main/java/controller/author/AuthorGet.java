package controller.author;

import helper.Message;
import model.AuthorDto;
import model.ResponseDto;
import security.Security;
import service.AuthorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/author/get")
public class AuthorGet extends HttpServlet {
    private AuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseDto<List<AuthorDto>> responseDto = authorService.getAll();
        if (responseDto.isSuccess()) {
            req.setAttribute("authors", responseDto.getData());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/author/getAllAuthors.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            Message.print(req, resp,responseDto.getMessage());
        }
    }
}
