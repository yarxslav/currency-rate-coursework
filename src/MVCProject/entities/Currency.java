package MVCProject.entities;

import java.util.HashMap;
import java.util.Objects;

public class Currency implements CurrencyInterface{

    private String code;
    private String name;
    private HashMap<Date, Double> dateRate = new HashMap<>();

    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public void addDateRate (Date date, Double rate) {
        dateRate.put(date,rate);
    }

    @Override
    public void removeDateRate(Date date) {
        dateRate.remove(date);
    }

    public HashMap<Date, Double> getDateRate() {
        return dateRate;
    }

    public void setDateRate(HashMap<Date, Double> dateRate) {
        this.dateRate = dateRate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
