class Product{
    private static double discount = 10.0;
    private String productName;
    private final int productID;
    private double price;
    private int quantity;
    public Product(String productName, int productID, double price, int quantity) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Updated Discount: " + discount + "%");
    }
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product Name: " + productName);
            System.out.println("Product ID: " + productID);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        } else {
            System.out.println("Invalid Product Object!");
        }
    }
    public static void main(String[] args) {
        Product prod1 = new Product("Laptop", 1001, 1200.0, 2);
        Product prod2 = new Product("Smartphone", 1002, 800.0, 3);
        prod1.displayProductDetails();
        System.out.println("------------------------");
        prod2.displayProductDetails();
        updateDiscount(15.0);
        System.out.println("------------------------");
        prod1.displayProductDetails();
    }
}