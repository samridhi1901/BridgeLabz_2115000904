import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed an order: " + order.getOrderId());
    }
}

class Order {
    private static int idCounter = 1;
    private int orderId;
    private List<Product> products;

    public Order() {
        this.orderId = idCounter++;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        for (Product product : products) {
            System.out.println("- " + product.getName());
        }
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
}

public class ECommerceDemo {
    public static void main(String[] args) {
        Customer customer = new Customer("Sam");
        
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);
        
        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);
        
        customer.placeOrder(order);
        order.showOrderDetails();
    }
}
