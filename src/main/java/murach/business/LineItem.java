package murach.business;

import java.io.Serializable;
import java.text.NumberFormat;

public class LineItem implements Serializable {
    private Product product;
    private int quantity;

    public LineItem () {
        product = null;
        quantity = 0;
    }

    public LineItem (Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void setProduct (Product product) {
        this.product = product;
    }

    public Product getProduct () {
        return this.product;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity () {
        return this.quantity;
    }

    public double getAmount () {
        return Math.round(product.getPrice() * quantity * 100.0) / 100.0;
    }

    public String getAmountCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getAmount());
    }
}