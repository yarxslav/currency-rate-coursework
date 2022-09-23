package MVCProject.model;

import MVCProject.entities.Currency;
import MVCProject.entities.Date;
import MVCProject.database.CurrencyDB;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GetAction implements GetActionInterface{

    @Override
    public Currency getCurrency(String code) {
        CurrencyDB database = CurrencyDB.getDatabase();

        ArrayList<Currency> currencies = database.getCurrencies();

        ArrayList<String> codes = currencies.stream()
                .map(Currency::getCode)
                .collect(Collectors.toCollection(ArrayList::new));

        int index = codes.indexOf(code);

        return currencies.get(index);
    }

    @Override
    public boolean containsCurrency(String code) {
        CurrencyDB database = CurrencyDB.getDatabase();

        ArrayList<Currency> currencies = database.getCurrencies();

        ArrayList<String> codes = currencies.stream()
                .map(Currency::getCode)
                .collect(Collectors.toCollection(ArrayList::new));

        return codes.contains(code);
    }

    @Override
    public Date getDate(String date) {
        CurrencyDB database = CurrencyDB.getDatabase();

        ArrayList<Date> dates = database.getDates();

        ArrayList<String> codes = dates.stream()
                .map(Date::getDate)
                .collect(Collectors.toCollection(ArrayList::new));

        int index = codes.indexOf(date);

        return dates.get(index);
    }

    @Override
    public boolean containsDate(String date) {
        CurrencyDB database = CurrencyDB.getDatabase();

        ArrayList<Date> dates = database.getDates();

        ArrayList<String> codes = dates.stream()
                .map(Date::getDate)
                .collect(Collectors.toCollection(ArrayList::new));

        return codes.contains(date);
    }

    @Override
    public ArrayList<Date> getRates (Date dateFrom, Date dateTo, String code) {
        Currency currency = getCurrency(code);
        ArrayList<Date> completeDates = new ArrayList<>();
        ArrayList<Date> dates = CurrencyDB.getDatabase().getDates();
        ArrayList<Date> rates = new ArrayList<>();

        for (Date d : dates) {
            if (d.getLocalDate().compareTo(dateFrom.getLocalDate())>0||d.getLocalDate().compareTo(dateTo.getLocalDate()) < 0){
                completeDates.add(d);
            }
        }

        completeDates.sort(Comparator.comparing(Date::getLocalDate));

        for (Date d : completeDates) {
           if (currency.getDateRate().containsKey(d)) {
               rates.add(d);
           }
        }

        rates.sort(Comparator.comparing(Date::getLocalDate));

        return rates;
    }

}
