package security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Security {
    // singltone
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
        boolean hasPermession = username != null
                && !username.equals("");
        return hasPermession;
    }

    public static void addCookieAndSession(HttpServletRequest req, HttpServletResponse resp, String username) {
        Cookie cookie = new Cookie("authApp", username);
        cookie.setMaxAge(60 * 5);  // 5 min
        resp.addCookie(cookie);
    }

    public static void logout(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = new Cookie("authApp", "");
        cookie.setMaxAge(0);  // invalidate cookie
        resp.addCookie(cookie);
    }

}
