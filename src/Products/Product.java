package Products;
public class Product {

    protected String name;
    protected double price;
    protected int quantity;
    public double weight = 0; // in grams

    public Product(String name, int price, int quantity, int weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
    }

    public String getName() {
        if (name == null || name.isEmpty()) {
            return "Unknown Product";
        }
        else{
            return name;
        }
    }    
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getWeight() {
        return weight;
    }
    public void updateQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Quantity cannot be negative.");
        } else {
            this.quantity = quantity;
        }
    }
    public void updatePrice(int price) {
        if (price < 0) {
            System.out.println("Price cannot be negative.");
        } else {
            this.price = price;
        }
    }
  




    
}
