package security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Security {

    public static boolean hasPermission(HttpServletRequest req) {
        String username = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("authApp")) {
                    username = cookie.getValue();
                }
            }
        }
        HttpSession session = req.getSession();
        String sessionAttribute = (String) session.getAttribute("authApp");
        return
                username != null
                        && !username.equals("") && sessionAttribute.equals(username);
    }

    public static void addCookieAndSession(HttpServletRequest req, HttpServletResponse resp, String username){
        Cookie cookie = new Cookie("authApp", username);
        cookie.setMaxAge(60 * 5);  // 5 min
        resp.addCookie(cookie);
        HttpSession session = req.getSession();
        session.setAttribute("authApp", username);
    }

    public static void logout(HttpServletRequest req, HttpServletResponse resp){
        Cookie cookie = new Cookie("authApp", "");
        cookie.setMaxAge(0);  // invalidate cookie
        resp.addCookie(cookie);
        HttpSession session = req.getSession();
        session.invalidate(); // invalidate session
    }

}
