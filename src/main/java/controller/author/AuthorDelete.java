package controller.author;

import helper.IntegerHelper;
import helper.messages.AppMessage;
import model.ResponseDto;
import service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static helper.messages.AppMessage.ERROR;

@WebServlet("/author/delete")
public class AuthorDelete extends HttpServlet {
    private AuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/author/deleteAuthor.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            String id = req.getParameter("authorId");
            boolean idBool = IntegerHelper.isDigit(id);
            if (!idBool) {
                writer.write("Please enter valid field for authorId");
            }else {
                ResponseDto<String> responseDto = authorService.delete(Integer.parseInt(id));
                writer.write(responseDto.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write(ERROR);
        }
    }
}
