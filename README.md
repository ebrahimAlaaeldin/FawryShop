# 🛒 FawryShop E-Commerce System

Welcome to **FawryShop**! This is a Java-based e-commerce system designed for learning, testing, and demonstrating core e-commerce features in a clean, extensible way.

## 📁 Folder Structure

- `src/` — Java source code
- `lib/` — External dependencies (if any)
- `bin/` — Compiled `.class` files

## 🚀 Features

- Define products with name, price, quantity, and weight
- Support for expirable products (e.g., Cheese, Milk, Biscuits)
- Support for shippable and unshippable products (e.g., TV, Gift Cards)
- Cart management with quantity checks and expiry validation
- Checkout process with:
  - Subtotal, shipping, and total calculation
  - Customer balance validation
  - Shipment notice for shippable items
  - Error handling for empty cart, out-of-stock, expired, or insufficient balance
- Extensible product categories using enums and inheritance
- Test cases for all major scenarios

## 🧑‍💻 How to Run

1. **Compile:**
   ```sh
   javac -d bin src/*.java
   ```
2. **Run:**
   ```sh
   java -cp bin App
   ```

## 🧪 Test Cases

The `App.java` file includes code examples that cover:
- ✅ Normal checkout with all product types
- ❌ Empty cart
- 💸 Insufficient balance
- 📦 Out of stock
- ⏰ Expired product

## 🏗️ Extending the System

- Add new product types by extending the `Product` class and implementing `Shippable` or `Expirable` as needed.
- Add new categories to the enums (`GroceryType`, `ElectronicsCategory`, `UnshippableProductType`).
- Add more test cases in `App.java` for custom scenarios.

## 📚 Dependency Management

Use the `JAVA PROJECTS` view in VS Code to manage dependencies. More details [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

---

## 📬 Contact

Created with ❤️ by **Ibrahim Alaaeldin**

- 📧 Email: [ebrahimalaaeldin@gmail.com](mailto:ebrahimalaaeldin@gmail.com)  
- 🧑‍💻 GitHub: [@ebrahimAlaaeldin](https://github.com/ebrahimAlaaeldin)

Made with ❤️ for the Fawry Quantum Internship Challenge.
