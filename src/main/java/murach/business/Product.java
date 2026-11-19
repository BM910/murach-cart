package murach.business;

import java.io.Serializable;
import java.text.NumberFormat;

public class Product implements Serializable {
    private String productCode;
    private String description;
    private double price;

    public Product () {
        productCode = "";
        description = "";
        price = 0;
    }

    public Product (String productCode, String description, double price) {
        this.productCode = productCode;
        this.description = description;
        this.price = price;
    }

    public void setProductCode (String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode () {
        return this.productCode;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getDescription () {
        return this.description;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public double getPrice () {
        return this.price;
    }

    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
}