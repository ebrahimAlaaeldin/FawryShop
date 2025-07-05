package Products;
public class UnshippableProduct extends Product {
    private UnshippableProductType type;
    private String details; // e.g., code, link, description

    public UnshippableProduct(UnshippableProductType type, String name, int price, int quantity, String details) {
        super(name, price, quantity, 0);
        this.type = type;
        this.details = details;
    }

    public UnshippableProductType getType() {
        return type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
