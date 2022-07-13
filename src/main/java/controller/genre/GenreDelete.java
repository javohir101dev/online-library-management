package controller.genre;

import helper.IntegerHelper;
import helper.Message;
import model.ResponseDto;
import service.GenreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/genre-delete")
public class GenreDelete extends HttpServlet {
    private GenreService genreService = new GenreService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/genre/deleteGenre.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("idGenre");

            if (!IntegerHelper.isDigit(id)) {
                resp.getWriter().write("Please enter right id: ");
            }else {
                ResponseDto<Boolean> responseDto = genreService.delete(Integer.parseInt(id));
                Message.print(req, resp,responseDto.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            Message.print(req, resp,"Error please right id: ");
        }

    }
}
