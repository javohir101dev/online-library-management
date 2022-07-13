package helper;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Message   {

    public static void print(HttpServletRequest req, HttpServletResponse resp, String message) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/message.jsp");
        req.setAttribute("message", message);
        requestDispatcher.forward(req, resp);
    }
}
