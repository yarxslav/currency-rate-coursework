package MVCProject.model;

import MVCProject.entities.Currency;
import MVCProject.entities.Date;

import java.util.ArrayList;

public interface GetActionInterface {
    public Currency getCurrency(String code);

    public boolean containsCurrency(String code);

    public Date getDate(String date);

    public boolean containsDate(String date);

    public ArrayList<Date> getRates(Date dateFrom, Date dateTo, String code);

}
