package MVCProject.model;

import MVCProject.entities.Admin;
import MVCProject.database.CurrencyDB;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Login implements Action {

    @Override
    public String process(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        CurrencyDB database = CurrencyDB.getDatabase();
        Map<String, Admin> admins = database.getAdmins();
        Admin admin = admins.get(login);
        String resultPage = (admin != null && admin.getPassword().equals(password)) ? "controller?action=main" : "login.jsp";

        if (admin == null) {
            request.setAttribute("notExists", "Account not found");
        } else if (admin.getPassword().equals(password)){
            request.getSession().setAttribute("admin", admin);
        } else {
            request.setAttribute("notExists", "Incorrect password");
        }

        return resultPage;
    }
}
