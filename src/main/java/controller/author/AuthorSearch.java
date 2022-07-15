package controller.author;

import entity.Author;
import helper.Message;
import model.AuthorDto;
import model.BookShow;
import model.ResponseDto;
import repository.AuthorRepository;
import repository.impl.AuthorRepositoryImpl;
import service.AuthorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/author/search")
public class AuthorSearch extends HttpServlet {

    AuthorService authorService = new AuthorService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String search = req.getParameter("search");
        ResponseDto<List<Author>> responseDto = authorService.getAllShowSearch(search);
        if (responseDto.isSuccess()) {
            req.setAttribute("authors", responseDto.getData());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/author/authorSearch.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            Message.print(req, resp, responseDto.getMessage());
        }
    }

}
