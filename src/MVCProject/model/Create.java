package MVCProject.model;

import MVCProject.entities.Currency;
import MVCProject.database.CurrencyDB;

import javax.servlet.http.HttpServletRequest;

public class Create implements Action {

    @Override
    public String process(HttpServletRequest request) {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        GetAction get = new GetAction();

        if (!get.containsCurrency(code)){
            Currency currency = new Currency(code, name);
            CurrencyDB.getDatabase().addCurrency(currency);
        } else {
            request.setAttribute("contains", "already contains");
        }

        return "controller?action=main";
    }
}
