package MVCProject.model;

import MVCProject.entities.Currency;

import javax.servlet.http.HttpServletRequest;

public class Edit implements Action {

    @Override
    public String process(HttpServletRequest request) {
        GetAction get = new GetAction();

        if (get.containsCurrency(request.getParameter("code"))) {
            Currency currency = get.getCurrency(request.getParameter("code"));
            currency.setCode(request.getParameter("newCode"));
            currency.setName(request.getParameter("name"));
            request.setAttribute("currency", currency);
        } else {
            request.setAttribute("notEdit", "not edit");
        }

        return "controller?action=main";
    }
}
