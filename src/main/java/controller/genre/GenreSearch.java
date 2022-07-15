package controller.genre;

import entity.Author;
import entity.Genre;
import helper.Message;
import model.ResponseDto;
import service.GenreService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/genre/search")
public class GenreSearch extends HttpServlet {

    GenreService genreService = new GenreService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String search = req.getParameter("search");
        ResponseDto<List<Genre>> responseDto = genreService.getAllShowSearch(search);
        if (responseDto.isSuccess()) {
            req.setAttribute("genres", responseDto.getData());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/genre/genreSearch.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            Message.print(req, resp, responseDto.getMessage());
        }
    }

}
