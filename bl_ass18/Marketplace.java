import java.util.ArrayList;
import java.util.List;

abstract class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class BookCategory extends Category {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends Category {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends Category {
    public GadgetCategory() {
        super("Gadgets");
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayProduct() {
        System.out.println("Product: " + name + " | Category: " + category.getName() + " | Price: $" + price);
    }
}

class ProductCatalog {
    private List<Product<? extends Category>> products = new ArrayList<>();

    public void addProduct(Product<? extends Category> product) {
        products.add(product);
    }

    public void displayCatalog() {
        for (Product<? extends Category> product : products) {
            product.displayProduct();
        }
    }

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() - (product.getPrice() * (percentage / 100));
        product.setPrice(newPrice);
        System.out.println("Discount applied to " + product.getName() + ". New price: $" + newPrice);
    }
}

public class Marketplace {
    public static void main(String[] args) {
        Product<BookCategory> book1 = new Product<>("Java Programming", 50.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Casual Shirt", 25.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 499.99, new GadgetCategory());

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book1);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        System.out.println("Product Catalog:");
        catalog.displayCatalog();

        System.out.println("\nApplying Discounts:");
        ProductCatalog.applyDiscount(book1, 10);
        ProductCatalog.applyDiscount(shirt, 15);
        ProductCatalog.applyDiscount(phone, 5);

        System.out.println("\nUpdated Catalog:");
        catalog.displayCatalog();
    }
}
