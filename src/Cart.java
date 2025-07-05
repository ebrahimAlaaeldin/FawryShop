import java.util.*;

import Products.ExpirableProduct;
import Products.Product;

public class Cart {
    public static class CartItem {
        public Product product;
        public int quantity;
        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }
    }
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }
        if (product.getQuantity() < quantity) {
            System.out.println("Not enough stock for " + product.getName());
            return;
        }
        if (product instanceof ExpirableProduct && ((ExpirableProduct)product).isExpired()) {
            System.out.println(product.getName() + " is expired and cannot be added.");
            return;
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public void clear() {
        items.clear();
    }
}
