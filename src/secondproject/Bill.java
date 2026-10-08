package secondproject;
import java.util.Scanner;

public class Bill {

    void calculateBill(InventoryService service, Scanner sc) {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = service.getProduct(id);

        if (p != null) {

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            try {

                double total = p.getPrice() * quantity;

                p.sellProduct(quantity);

                System.out.println("\n===== BILL =====");
                System.out.println("Product : " + p.getProductName());
                System.out.println("Price   : Rs." + p.getPrice());
                System.out.println("Quantity: " + quantity);
                System.out.println("Total   : Rs." + total);

            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());
            }

        } else {

            System.out.println("Product not found");
        }
    }
}