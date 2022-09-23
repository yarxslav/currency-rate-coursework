package MVCProject.model;

import MVCProject.entities.Date;
import MVCProject.database.CurrencyDB;

import javax.servlet.http.HttpServletRequest;

public class TodayRate implements Action {

    @Override
    public String process(HttpServletRequest request) {
        CurrencyDB database = CurrencyDB.getDatabase();
        Date today = database.getToday();

        request.setAttribute("todayCurrencies", today.getCurrencies());
        request.setAttribute("today", today);

        return "index.jsp";
    }
}
