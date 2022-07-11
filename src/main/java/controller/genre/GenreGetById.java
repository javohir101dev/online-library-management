package controller.genre;

import helper.IntegerHelper;
import repository.GenreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/genre-getById")
public class GenreGetById extends HttpServlet {
    private GenreService genreService = new GenreService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/genre/getByIdGenre.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String id = req.getParameter("idGenre");

            if (!IntegerHelper.isDigit(id)) {
                resp.getWriter().write("Please enter right id: ");
            }
            genreService.getById(Integer.parseInt(id));
        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().write("Error please right id: ");
        }

    }
}
