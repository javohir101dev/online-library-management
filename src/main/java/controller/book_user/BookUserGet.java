package controller.book_user;

import model.BookUserAll;
import model.ResponseDto;
import repository.BookUserRepository;
import repository.impl.BookUserRepositoryImpl;
import service.BookUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book-user/get")
public class BookUserGet extends HttpServlet {

    BookUserRepository bookUserRepository = BookUserRepositoryImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<BookUserAll> bookUserAlls =  bookUserRepository.getAllGivenBooks();
        req.setAttribute("bookUsers", bookUserAlls);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book-user/bookUserGet.jsp");
        requestDispatcher.forward(req, resp);
    }
}
