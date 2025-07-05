import Products.Electronics;
import Products.ElectronicsCategory;

import Products.Groceries;
import Products.GroceryType;

import Products.UnshippableProduct;
import Products.UnshippableProductType;

public class App {
    public static void main(String[] args) throws Exception {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        // Groceries
        Groceries cheese = new Groceries(GroceryType.CHEESE, "Cheese", 100, 5, 400, sdf.parse("2025-12-31"));
        Groceries biscuits = new Groceries(GroceryType.BISCUITS, "Biscuits", 150, 2, 700, sdf.parse("2025-12-31"));
        Groceries milk = new Groceries(GroceryType.MILK, "Milk", 60, 10, 1000, sdf.parse("2025-12-31"));
        Groceries bread = new Groceries(GroceryType.BREAD, "Bread", 30, 20, 500, sdf.parse("2025-12-31"));
        // Electronics
        Electronics tv = new Electronics("TV", 200, 3, 5000, "Samsung", "QLED", "24", "Black", ElectronicsCategory.TV);
        Electronics laptop = new Electronics("Laptop", 3000, 5, 2500, "Dell", "XPS", "12", "Silver", ElectronicsCategory.LAPTOP);
        // Unshippable
        UnshippableProduct scratchCard = new UnshippableProduct(UnshippableProductType.MOBILE_SCRATCH_CARDS, "Scratch Card", 50, 10, "1234-5678");
        UnshippableProduct giftCard = new UnshippableProduct(UnshippableProductType.GIFT_CARDS, "Gift Card", 100, 50, "GFT-2025-0001");

        // Test case 1: Normal checkout
        Customer customer = new Customer("Ali", 5000);
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(tv, 3);
        cart.add(scratchCard, 1);
        cart.add(biscuits, 1);
        cart.add(milk, 2);
        cart.add(bread, 3);
        cart.add(laptop, 1);
        cart.add(giftCard, 2);
        System.out.println("\n--- Example 1: Normal Checkout with all product types ---");
        CheckoutService.checkout(customer, cart);

        // Test case 2: Empty cart
        Customer customer2 = new Customer("Omar", 1000);
        Cart emptyCart = new Cart();
        System.out.println("\n--- Example 2: Empty Cart ---");
        CheckoutService.checkout(customer2, emptyCart);

        // Test case 3: Insufficient balance
        Customer poorCustomer = new Customer("Sara", 10);
        Cart cart2 = new Cart();
        cart2.add(cheese, 1);
        System.out.println("\n--- Example 3: Insufficient Balance ---");
        CheckoutService.checkout(poorCustomer, cart2);

        // Test case 4: Out of stock
        Cart cart3 = new Cart();
        cart3.add(tv, 100); // more than available
        System.out.println("\n--- Example 4: Out of Stock ---");
        CheckoutService.checkout(customer, cart3);

        // Test case 5: Expired product
        Groceries expiredCheese = new Groceries(GroceryType.CHEESE, "Old Cheese", 80, 2, 400, sdf.parse("2020-01-01"));
        Cart cart4 = new Cart();
        cart4.add(expiredCheese, 1);
        System.out.println("\n--- Example 5: Expired Product ---");
        CheckoutService.checkout(customer, cart4);

        // Test case 6: test deduction of balance for Ahmed
        System.out.println("\n--- Example 6: Deduct Balance ---");
        cart.clear();
        cart.add(biscuits, 1);
        cart.add(biscuits, 1);
        cart.add(biscuits, 1);
        cart.add(biscuits, 1);
        CheckoutService.checkout(customer, cart);
        System.out.println("Remaining balance for " + customer.getName() + ": " + customer.getBalance());
    }
}
