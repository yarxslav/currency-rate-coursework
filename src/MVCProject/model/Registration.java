package MVCProject.model;

import MVCProject.entities.Admin;
import MVCProject.database.CurrencyDB;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class Registration implements Action {

    @Override
    public String process(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Admin admin = new Admin(login, password);

        CurrencyDB database = CurrencyDB.getDatabase();
        Map<String, Admin> admins = database.getAdmins();
        boolean add = false;

        if (!admins.containsKey(login)) {
            admins.put(login, admin);
            database.setAdmins(admins);
            add = true;
        }

        if (add) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
        } else {
            request.setAttribute("notAdd", "This admin already exists");
        }

        return (add) ? "controller?action=main" : "registration.jsp";
    }
}
