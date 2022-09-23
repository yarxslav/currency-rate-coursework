package MVCProject.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Date implements DateInterface {

    private final LocalDate localDate;
    private String date;
    private ArrayList<Currency> currencies = new ArrayList<>();
    private HashMap<Currency, Double> rates = new HashMap<>();

    public Date(String date) {
        this.date = date;
        localDate = LocalDate.parse(date);
    }

    @Override
    public void addRate (Currency currency, Double rate) {
        rates.put(currency,rate);
    }

    @Override
    public void removeRate (Currency currency) {
        rates.remove(currency);
    }

    public HashMap<Currency, Double> getRates() {
        return rates;
    }

    public void setRates(HashMap<Currency, Double> rates) {
        this.rates = rates;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public void addCurrency(Currency currency) {
        currencies.add(currency);
    }

    @Override
    public void removeCurrency(Currency currency) {
        currencies.remove(currency);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }
}
