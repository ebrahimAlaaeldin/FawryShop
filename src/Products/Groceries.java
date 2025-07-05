package Products;
import java.util.Date;

public class Groceries extends ExpirableProduct implements Shippable {
    private GroceryType type;
  

    public Groceries(GroceryType type, String name, int price, int quantity, int weight, Date expiryDate) {
        super(name, price, quantity, weight, expiryDate);
        this.type = type;
    }

    public GroceryType getType() {
        return type;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }
    @Override
    public double getShippingCost() {
        return 30.0; // Constant shipping cost for groceries
    }
    
        
}
