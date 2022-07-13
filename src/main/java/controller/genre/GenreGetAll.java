package controller.genre;

import helper.Message;
import model.GenreDto;
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

@WebServlet("/genre-getAll")
public class GenreGetAll extends HttpServlet {
    private GenreService genreService =new GenreService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseDto<List<GenreDto>> responseDto = genreService.getAll();
        if (responseDto.isSuccess()) {
            req.setAttribute("genres", responseDto.getData());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/genre/genreGetAll.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            Message.print(req, resp,responseDto.getMessage());
        }
    }
}
