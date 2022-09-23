package MVCProject.model;

import MVCProject.entities.Currency;
import MVCProject.entities.Date;
import MVCProject.database.CurrencyDB;

import javax.servlet.http.HttpServletRequest;

public class Delete implements Action {

    @Override
    public String process(HttpServletRequest request) {
        GetAction get = new GetAction();

        if (get.containsCurrency(request.getParameter("code"))) {
            Currency currency = get.getCurrency(request.getParameter("code"));
            CurrencyDB.getDatabase().removeCurrency(currency);
            for (Date d : CurrencyDB.getDatabase().getDates()) {
                if (d.getCurrencies().contains(currency)){
                    d.removeCurrency(currency);
                    d.removeRate(currency);
                }
            }
        } else {
            request.setAttribute("notDelete", "not deleted");
        }

        return "controller?action=main";
    }
}
