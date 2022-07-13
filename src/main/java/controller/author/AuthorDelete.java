package controller.author;

import helper.IntegerHelper;
import helper.Message;
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
import java.io.PrintWriter;

import static helper.messages.AppMessage.ERROR;

@WebServlet("/author/delete")
public class AuthorDelete extends HttpServlet {
    private AuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/author/deleteAuthor.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("authorId");
            boolean idBool = IntegerHelper.isDigit(id);
            if (!idBool) {
                Message.print(req, resp,"Please enter valid field for authorId");
            } else {
                ResponseDto<String> responseDto = authorService.delete(Integer.parseInt(id));
                Message.print(req, resp,responseDto.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Message.print(req, resp,ERROR);
        }
    }
}
