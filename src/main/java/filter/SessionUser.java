package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUser {
    public static boolean checkUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("idUser") != null) {
                return true;
            }
        }
        return false;
    }
}
