package secondproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryService {

    private Map<Integer, Product> products = new HashMap<>();

    void addProduct(Scanner sc) {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.println("1. LAPTOP");
        System.out.println("2. MOBILE");
        System.out.println("3. ACCESSORY");
        System.out.println("4. HOME_APPLIANCE");

        System.out.print("Enter Category: ");
        int choice = sc.nextInt();

        Category category;

        if (choice == 1) {
            category = Category.LAPTOP;
        } else if (choice == 2) {
            category = Category.MOBILE;
        } else if (choice == 3) {
            category = Category.ACCESSORY;
        } else {
            category = Category.HOME_APPLIANCE;
        }

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Stock: ");
        int stock = sc.nextInt();

        Product p = new Product(id, name, category, price, stock);

        products.put(id, p);

        System.out.println("Product added successfully");
    }

    void searchProduct(Scanner sc) {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = products.get(id);

        if (p != null) {
            p.display();
        } else {
            System.out.println("Product not found");
        }
    }

    void updatePrice(Scanner sc) {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = products.get(id);

        if (p != null) {

            System.out.print("Enter New Price: ");
            double price = sc.nextDouble();

            p.updatePrice(price);

            System.out.println("Price updated successfully");

        } else {

            System.out.println("Product not found");
        }
    }

    void addStock(Scanner sc) {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = products.get(id);

        if (p != null) {

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            p.addStock(quantity);

            System.out.println("Stock added successfully");

        } else {

            System.out.println("Product not found");
        }
    }

    void sellProduct(Scanner sc) {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = products.get(id);

        if (p != null) {

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            try {

                p.sellProduct(quantity);

                System.out.println("Product sold successfully");

            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());
            }

        } else {

            System.out.println("Product not found");
        }
    }

    void showAllProducts() {

        System.out.println("\n===== ALL PRODUCTS =====");

        for (Product p : products.values()) {
            p.display();
        }
    }

    void showLowStockProducts() {

        System.out.println("\n===== LOW STOCK PRODUCTS =====");

        for (Product p : products.values()) {

            if (p.getStock() < 5) {
                p.display();
            }
        }
    }

    void deleteProduct(Scanner sc) {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (products.containsKey(id)) {

            products.remove(id);

            System.out.println("Product deleted successfully");

        } else {

            System.out.println("Product not found");
        }
    }

    Product getProduct(int id) {

        return products.get(id);
    }
}