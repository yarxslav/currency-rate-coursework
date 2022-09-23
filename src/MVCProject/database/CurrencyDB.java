package MVCProject.database;

import MVCProject.entities.Admin;
import MVCProject.entities.Currency;
import MVCProject.entities.Date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;



public class CurrencyDB{

    private static CurrencyDB database = new CurrencyDB();
    private Map<String, Admin> admins = new HashMap<>();
    private final Date today = new Date(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
    private ArrayList<Date> dates = new ArrayList<>();
    private ArrayList<Currency> currencies = new ArrayList<>();

    private CurrencyDB() {
    }

    {
        dates.add(today);
    }

    public static CurrencyDB getDatabase() {
        if (database == null) {
            database = new CurrencyDB();
        }
        return database;
    }

    public void addCurrency(Currency currency) {
        currencies.add(currency);
    }

    public void removeCurrency(Currency currency) {
        currencies.remove(currency);
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }

    public void addDate(Date date) {
        dates.add(date);
    }

    public void removeDate(Date date) {
        dates.remove(date);
    }

    public static void setDatabase(CurrencyDB database) {
        CurrencyDB.database = database;
    }

    public ArrayList<Date> getDates() {
        return dates;
    }

    public void setDates(ArrayList<Date> dates) {
        this.dates = dates;
    }

    public Map<String, Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(Map<String, Admin> admins) {
        this.admins = admins;
    }

    public Date getToday() {
        return today;
    }

}
