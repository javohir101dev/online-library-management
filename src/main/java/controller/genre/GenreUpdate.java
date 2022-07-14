package controller.genre;

import helper.IntegerHelper;
import helper.Message;
import model.AuthorDto;
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

import static helper.messages.AppMessage.ERROR;

@WebServlet("/genre-update")
public class GenreUpdate extends HttpServlet {
    private GenreService genreService = new GenreService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if (id == null || !IntegerHelper.isDigit(id)) {
                Message.print(req, resp, "Please enter valid Id");
            } else {
                ResponseDto<GenreDto> responseDto = genreService.getById(Integer.parseInt(id));
                if (responseDto.isSuccess()) {
                    GenreDto genreDto = responseDto.getData();
                    req.setAttribute("genre", genreDto);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/genre/updateGenre.jsp");
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
            String id = req.getParameter("idGenre");
            if (!IntegerHelper.isDigit(id)) {
                resp.getWriter().write("Please enter valid id: ");
            }
            String name = req.getParameter("nameGenre");
            GenreDto genreDto = new GenreDto(Integer.parseInt(id), name);
            ResponseDto<GenreDto> responseDto = genreService.update(genreDto);
            Message.print(req, resp,responseDto.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            Message.print(req, resp,"Error please enter valid name or id");
        }
    }
}
