package secondproject;

public class Product {

    private int productId;
    private String productName;
    private Category category;
    private double price;
    private int stock;

    public Product(int productId, String productName, Category category,
                   double price, int stock) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void updatePrice(double price) {
        this.price = price;
    }

    public void addStock(int quantity) {
        stock = stock + quantity;
    }

    public void sellProduct(int quantity) {

        if (stock == 0) {
            throw new IllegalArgumentException("Product is out of stock");
        }

        if (quantity > stock) {
            throw new IllegalArgumentException("Not enough stock");
        }

        stock = stock - quantity;
    }

    public void display() {

        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Category     : " + category);
        System.out.println("Price        : Rs." + price);
        System.out.println("Stock        : " + stock);
        System.out.println("-------------------------");
    }
}