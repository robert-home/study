package pl.rbudner.study.coherence;

import java.io.Serializable;
import java.util.Date;

public class Ccy implements Serializable, Comparable<Ccy> {

    private String name;
    private int price;
    private Date date;

    public Ccy(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(Ccy other) {
        return Integer.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return name + "=" + price + " on " + ((date != null) ? date : "");
    }
}
