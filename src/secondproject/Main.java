package secondproject;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InventoryService service = new InventoryService();
        Bill bill = new Bill();

        while (true) {

            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Update Product Price");
            System.out.println("4. Add Stock");
            System.out.println("5. Sell Product");
            System.out.println("6. Show All Products");
            System.out.println("7. Show Low Stock Products");
            System.out.println("8. Calculate Bill");
            System.out.println("9. Delete Product");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    service.addProduct(sc);
                    break;

                case 2:
                    service.searchProduct(sc);
                    break;

                case 3:
                    service.updatePrice(sc);
                    break;

                case 4:
                    service.addStock(sc);
                    break;

                case 5:
                    service.sellProduct(sc);
                    break;

                case 6:
                    service.showAllProducts();
                    break;

                case 7:
                    service.showLowStockProducts();
                    break;

                case 8:
                    bill.calculateBill(service, sc);
                    break;

                case 9:
                    service.deleteProduct(sc);
                    break;

                case 10:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}