package MVCProject.entities;

public interface DateInterface {

    public void addCurrency(Currency currency);

    public void removeCurrency(Currency currency);

    public void addRate (Currency currency, Double rate);

    public void removeRate (Currency currency);
}
