package MVCProject.model;

import MVCProject.entities.Currency;
import MVCProject.entities.Date;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class Search implements Action {

    @Override
    public String process(HttpServletRequest request) {
        String dateFrom = request.getParameter("dateFrom");
        String dateTo = request.getParameter("dateTo");
        String code = request.getParameter("code");
        GetAction get = new GetAction();

        if (get.containsCurrency(code)) {
            Currency currency = get.getCurrency(code);
            if (get.containsDate(dateFrom) && get.containsDate(dateTo)) {
                ArrayList<Date> rates = get.getRates(get.getDate(dateFrom), get.getDate(dateTo), code);
                request.setAttribute("dateCurrency", currency);
                request.setAttribute("listOfDate", rates);
            } else {
                request.setAttribute("notDate", "not date");
            }
        } else {
            request.setAttribute("notContains", "not contains");
        }

        return "result.jsp";
    }
}
