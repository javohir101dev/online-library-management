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
import java.io.PrintWriter;

@WebServlet("/genre-add")
public class GenreAdd extends HttpServlet {
    private GenreService genreService = new GenreService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/genre/addGenre.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("nameGenre");
            GenreDto genreDto = GenreDto
                    .builder()
                    .name(name)
                    .build();
            ResponseDto<GenreDto> genreDtoResponseDto = genreService.addGenre(genreDto);
            Message.print(req, resp,genreDtoResponseDto.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            Message.print(req, resp,"Error please enter right name for genre");
        }
    }
}
