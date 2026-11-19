package murach.business;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Cart implements Serializable {
    private ArrayList<LineItem> items;

    public Cart () {
        items = new ArrayList<LineItem>();
    }

    public ArrayList<LineItem> getItems () {
        return items;
    }

    public int getCount () {
        return items.size();
    }

    public double getTotal () {
        double total = 0.0;
        for (LineItem item:items) {
            total += item.getAmount();
        }
        return total;
    }

    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }

    public void addItem (LineItem item) {
        String code = item.getProduct().getProductCode();
        int quantity = item.getQuantity();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getProductCode().equals(code)) {
                lineItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem (LineItem item) {
        String code = item.getProduct().getProductCode();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getProductCode().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }
}