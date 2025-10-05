package murach.business;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class LineItem implements Serializable {
    private int quantity;
    private Product product;

    public LineItem(){}

    public void setProduct(Product product){
        this.product = product;
    }
    public Product getProduct(){
        return product;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getQuantity(){
        return this.quantity;
    }

    public double getTotal() {
        double total = product.getPrice() * quantity;
        return total;
    }
    public String getTotalCurrencyFormat(){
        NumberFormat currency =  NumberFormat.getCurrencyInstance(Locale.US);
        return currency.format(this.getTotal());
    }
}
