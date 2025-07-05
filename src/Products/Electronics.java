package Products;
public class Electronics extends Product implements Shippable {
    private String brand;
    private String model;
    private String warrantyPeriod; // in months
    private String color;
    private ElectronicsCategory category; // e.g., "Mobile", "Laptop", "TV", etc.
    // Constructor
    public Electronics(String name, int price, int quantity, int weight, String brand, String model, String warrantyPeriod, String color, ElectronicsCategory category) {
        super(name, price, quantity, weight);
        this.brand = brand;
        this.model = model;
        this.warrantyPeriod = warrantyPeriod;
        this.color = color;
        this.category = category;
      
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }
    public String getColor() {
        return color;
    }
    public ElectronicsCategory getCategory() {
        return category;
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
        return 50.0; // constant shipping cost for electronics
    }
}
