package Products;
import java.util.Date;

public abstract class ExpirableProduct extends Product {
    protected Date expiryDate;

    public ExpirableProduct(String name, int price, int quantity, int weight, Date expiryDate) {
        super(name, price, quantity, weight);
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        Date now = new Date();
        return expiryDate != null && now.after(expiryDate);
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
