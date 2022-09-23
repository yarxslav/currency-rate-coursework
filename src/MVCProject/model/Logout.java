package MVCProject.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Logout implements Action {

    @Override
    public String process(HttpServletRequest request) {
        HttpSession session = request.getSession();

        session.removeAttribute("admin");

        return "controller?action=main";
    }
}
