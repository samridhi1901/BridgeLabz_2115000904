ximport java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayDetails();
}

class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics: " + getName() + ", Brand: " + brand);
    }
}

class Groceries extends WarehouseItem {
    private double weight;

    public Groceries(String name, double weight) {
        super(name);
        this.weight = weight;
    }

    @Override
    public void displayDetails() {
        System.out.println("Groceries: " + getName() + ", Weight: " + weight + "kg");
    }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture: " + getName() + ", Material: " + material);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public List<T> getItems() {
        return items;
    }

    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop", "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", "Samsung"));
        
        groceriesStorage.addItem(new Groceries("Apples", 2.5));
        groceriesStorage.addItem(new Groceries("Milk", 1.0));
        
        furnitureStorage.addItem(new Furniture("Chair", "Wood"));
        furnitureStorage.addItem(new Furniture("Table", "Metal"));

        System.out.println("Electronics Storage:");
        Storage.displayAllItems(electronicsStorage.getItems());

        System.out.println("\nGroceries Storage:");
        Storage.displayAllItems(groceriesStorage.getItems());

        System.out.println("\nFurniture Storage:");
        Storage.displayAllItems(furnitureStorage.getItems());
    }
}
