package murach.business;

import java.io.Serializable;
import java.text.NumberFormat;

public class Product implements Serializable {
    private int id;
    private String code;
    private String description;
    private double price;

    public Product(int id, String code, String description, double price) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public Product() {
        code = "";
        description = "";
        price = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
}