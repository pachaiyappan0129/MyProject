package firstproject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

enum Category {
    FOOD,
    TRAVEL,
    SHOPPING,
    BILLS,
    OTHERS
}

class Expense {
    private int id;
    private double amount;
    private Category category;
    private String description;
    private LocalDate date;

    public Expense(int id, double amount, Category category, String description, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ID:" + id + " | Amount: ₹" + amount + " | Category: " + category +
               " | Description: " + description + " | Date: " + date;
    }
}

 class PersonalExpenseTracker {
    static ArrayList<Expense> expenses = new ArrayList<>();
    static HashMap<Category, Double> categoryExpenses = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== PERSONAL EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. Display All Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Calculate Total Expense");
            System.out.println("5. Find Highest Expense");
            System.out.println("6. Calculate Category-wise Expense");
            System.out.println("7. Category Expense");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> displayExpense();
                case 3 -> deleteExpense();
                case 4 -> calculateTotal();
                case 5 -> findHighestExpense();
                case 6 -> categoryWiseExpense();
                case 7 -> categorizeExpense();
                case 8 -> {
                    System.out.println("Thank you for using Expense Tracker!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // Add Expense
    static void addExpense() {
        System.out.print("Enter Expense ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.println("Categories:");
        for (Category c : Category.values()) {
            System.out.println(c);
        }

        System.out.print("Enter Category: ");
        Category category = Category.valueOf(sc.next().toUpperCase());

        System.out.print("Enter Description: ");
        String description = sc.next();

        LocalDate date = LocalDate.now();
        Expense expense = new Expense(id, amount, category, description, date);
        expenses.add(expense);

        System.out.println("Expense added successfully!");
        System.out.println("Added on: " + LocalDateTime.now());
    }

    // Display all expenses
    static void displayExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }
        System.out.println("\n---- ALL EXPENSES ----");
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    // Delete Expense
    static void deleteExpense() {
        System.out.print("Enter Expense ID to delete: ");
        int id = sc.nextInt();
        boolean removed = expenses.removeIf(e -> e.getId() == id);
        if (removed) {
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("Expense ID not found.");
        }
    }

    // Calculate total expense
    static void calculateTotal() {
        double total = expenses.stream().mapToDouble(Expense::getAmount).sum();
        System.out.println("Total Expense = ₹" + total);
    }

    // Find highest expense
    static void findHighestExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses available.");
            return;
        }
        Expense highest = expenses.stream()
                .max((e1, e2) -> Double.compare(e1.getAmount(), e2.getAmount()))
                .get();
        System.out.println("\n---- HIGHEST EXPENSE ----");
        System.out.println(highest);
    }

    // Category-wise expenses
    static void categoryWiseExpense() {
        categoryExpenses.clear();
        for (Expense e : expenses) {
            categoryExpenses.put(e.getCategory(),
                    categoryExpenses.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }
        System.out.println("\n---- CATEGORY-WISE EXPENSES ----");
        if (categoryExpenses.isEmpty()) {
            System.out.println("No expenses available.");
            return;
        }
        categoryExpenses.forEach((category, amount) ->
                System.out.println(category + " = ₹" + amount));
    }

    // Categorize / display expenses by category
    static void categorizeExpense() {
        System.out.println("Enter category:");
        for (Category c : Category.values()) {
            System.out.println(c);
        }
        Category category = Category.valueOf(sc.nextLine().toUpperCase());
        System.out.println("\n---- " + category + " EXPENSES ----");
        var result = expenses.stream()
                .filter(e -> e.getCategory() == category)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            System.out.println("No expenses in this category.");
        } else {
            result.forEach(System.out::println);
        }
    }
}
