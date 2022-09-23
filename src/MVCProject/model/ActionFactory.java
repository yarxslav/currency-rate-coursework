package MVCProject.model;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


public class ActionFactory {

    private static ActionFactory factory = new ActionFactory();
    private final Map<String, Action> actions = new HashMap<>();

    private ActionFactory() {
    }

    public static ActionFactory actionFactory() {
        if (factory == null) {
            factory = new ActionFactory();
        }
        return factory;
    }

    {
        actions.put("register", new Registration());
        actions.put("login", new Login());
        actions.put("logout", new Logout());
        actions.put("main", new TodayRate());
        actions.put("delete", new Delete());
        actions.put("create", new Create());
        actions.put("set", new SetRate());
        actions.put("edit", new Edit());
        actions.put("search", new Search());
    }

    public Action getAction(HttpServletRequest request) {
        String action = request.getParameter("action");
        return actions.get(action);
    }
}
