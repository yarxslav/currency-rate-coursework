package MVCProject.model;

import MVCProject.entities.Currency;
import MVCProject.entities.Date;
import MVCProject.database.CurrencyDB;

import javax.servlet.http.HttpServletRequest;

public class SetRate implements Action {

    @Override
    public String process(HttpServletRequest request) {
        String code = request.getParameter("code");
        String date = request.getParameter("date");
        Double rate = Double.parseDouble(request.getParameter("rate"));
        GetAction get = new GetAction();

        if (get.containsCurrency(code)) {
            Currency currency = get.getCurrency(code);
            if (get.containsDate(date)) {
                Date date1 = get.getDate(date);
                if (!date1.getCurrencies().contains(currency)){
                    currency.addDateRate(date1, rate);
                    date1.addCurrency(currency);
                    date1.addRate(currency, rate);
                }
            } else {
                Date date1 = new Date(date);
                currency.addDateRate(date1, rate);
                date1.addCurrency(currency);
                date1.addRate(currency, rate);
                CurrencyDB.getDatabase().addDate(date1);
            }
        } else {
            request.setAttribute("notContains", "not contains");
        }

        return "controller?action=main";
    }
}
