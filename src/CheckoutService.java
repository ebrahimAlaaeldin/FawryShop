import java.util.ArrayList;
import java.util.List;
import Products.ExpirableProduct;
import Products.Product;
import Products.Shippable;
import Products.ShippingService;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }
        double subtotal = 0;
        double shipping = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (Cart.CartItem item : cart.getItems()) {
            Product product = item.product;

            // Expiration check
            if (product instanceof ExpirableProduct && ((ExpirableProduct) product).isExpired()) {
                System.out.println("Error: " + product.getName() + " is expired.");
                return;
            }

            // Stock check
            if (product.getQuantity() < item.quantity) {
                System.out.println("Error: Not enough stock for " + product.getName());
                return;
            }

            subtotal += product.getPrice() * item.quantity;

            // Shipping calculation
            if (product instanceof Shippable shippable) {
                shipping=0;
                for (int i = 0; i < item.quantity; i++) {
                    toShip.add(shippable);
                    // get max shipping cost 
                    double itemShippingCost = shippable.getShippingCost();
                    if (itemShippingCost > shipping) {
                        shipping = itemShippingCost;
                    }
                }
            }
        }

        double total = subtotal + shipping;

        // Balance check
        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        // Print shipment notice
        if (!toShip.isEmpty()) {
            ShippingService.ship(toShip);
        }

        // Print receipt
        printReceipt(cart, subtotal, shipping, total);

        // Deduct payment
        customer.deduct(total);

        // Update stock quantities
        for (Cart.CartItem item : cart.getItems()) {
            Product product = item.product;
            product.updateQuantity(product.getQuantity() - item.quantity);
        }
        System.out.println("Customer balance after payment: " + (int) customer.getBalance());
        // Clear cart
        cart.clear();
    }

    private static void printReceipt(Cart cart, double subtotal, double shipping, double total) {
        System.out.println("** Checkout receipt **");
        for (Cart.CartItem item : cart.getItems()) {
            System.out.printf("%dx %-12s %.0f%n", item.quantity, item.product.getName(), item.product.getPrice() * item.quantity);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t\t%.0f%n", subtotal);
        System.out.printf("Shipping\t\t%.0f%n", shipping);
        System.out.printf("Amount\t\t\t%.0f%n", total);
    }
}
