import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Double> cart = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedCart = new TreeMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    public void addToCart(String product) {
        if (productPrices.containsKey(product)) {
            double price = productPrices.get(product);
            cart.put(product, price);
            sortedCart.put(price, product);
        } else {
            System.out.println("Product not found: " + product);
        }
    }

    public void displayCartInOrder() {
        System.out.println("Cart (Order of Addition):");
        cart.forEach((product, price) -> System.out.println(product + ": $" + price));
    }

    public void displayCartSortedByPrice() {
        System.out.println("Cart (Sorted by Price):");
        sortedCart.forEach((price, product) -> System.out.println(product + ": $" + price));
    }

    public double calculateTotal() {
        return cart.values().stream().mapToDouble(Double::doubleValue).sum();
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 1200.99);
        cart.addProduct("Headphones", 199.49);
        cart.addProduct("Mouse", 49.99);
        cart.addProduct("Keyboard", 89.99);

        cart.addToCart("Laptop");
        cart.addToCart("Mouse");
        cart.addToCart("Keyboard");
        cart.addToCart("Headphones");

        cart.displayCartInOrder();
        System.out.println();
        cart.displayCartSortedByPrice();
        System.out.println("\nTotal Price: $" + cart.calculateTotal());
    }
}
