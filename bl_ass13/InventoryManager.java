class Item {
    int itemId;
    String itemName;
    int quantity;
    double price;
    Item next;

    public Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head;

    public void addItemAtBeginning(int itemId, String itemName, int quantity, double price) {
        Item newItem = new Item(itemId, itemName, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtEnd(int itemId, String itemName, int quantity, double price) {
        Item newItem = new Item(itemId, itemName, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addItemAtPosition(int itemId, String itemName, int quantity, double price, int position) {
        if (position <= 0) {
            addItemAtBeginning(itemId, itemName, quantity, price);
            return;
        }
        Item newItem = new Item(itemId, itemName, quantity, price);
        Item temp = head;
        int index = 0;
        while (temp != null && index < position - 1) {
            temp = temp.next;
            index++;
        }
        if (temp == null) {
            addItemAtEnd(itemId, itemName, quantity, price);
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    public void removeItemById(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head, prev = null;
        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;
        prev.next = temp.next;
    }

    public void updateItemQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found: " + itemId);
    }

    public void searchById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item ID: " + temp.itemId + " | Name: " + temp.itemName + " | Quantity: " + temp.quantity + " | Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found: " + itemId);
    }

    public void searchByName(String itemName) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item ID: " + temp.itemId + " | Name: " + temp.itemName + " | Quantity: " + temp.quantity + " | Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found: " + itemName);
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    public void sortByName(boolean ascending) {
        if (head == null || head.next == null) return;
        head = mergeSort(head, ascending, true);
    }

    public void sortByPrice(boolean ascending) {
        if (head == null || head.next == null) return;
        head = mergeSort(head, ascending, false);
    }

    private Item mergeSort(Item head, boolean ascending, boolean sortByName) {
        if (head == null || head.next == null) return head;

        Item middle = getMiddle(head);
        Item nextToMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, ascending, sortByName);
        Item right = mergeSort(nextToMiddle, ascending, sortByName);

        return merge(left, right, ascending, sortByName);
    }

    private Item merge(Item left, Item right, boolean ascending, boolean sortByName) {
        if (left == null) return right;
        if (right == null) return left;

        boolean condition;
        if (sortByName) {
            condition = ascending ? left.itemName.compareToIgnoreCase(right.itemName) < 0
                                  : left.itemName.compareToIgnoreCase(right.itemName) > 0;
        } else {
            condition = ascending ? left.price < right.price : left.price > right.price;
        }

        if (condition) {
            left.next = merge(left.next, right, ascending, sortByName);
            return left;
        } else {
            right.next = merge(left, right.next, ascending, sortByName);
            return right;
        }
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("Item ID: " + temp.itemId + " | Name: " + temp.itemName + " | Quantity: " + temp.quantity + " | Price: $" + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManager {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItemAtEnd(1, "Laptop", 10, 900.50);
        inventory.addItemAtEnd(2, "Mouse", 50, 25.75);
        inventory.addItemAtBeginning(3, "Keyboard", 30, 45.99);
        inventory.addItemAtPosition(4, "Monitor", 15, 150.00, 2);

        System.out.println("Inventory:");
        inventory.displayInventory();

        System.out.println("\nTotal Inventory Value:");
        inventory.calculateTotalValue();

        System.out.println("\nSearch by ID: 2");
        inventory.searchById(2);

        System.out.println("\nSearch by Name: Monitor");
        inventory.searchByName("Monitor");

        System.out.println("\nUpdating quantity of Item ID 1 to 8");
        inventory.updateItemQuantity(1, 8);

        System.out.println("\nInventory after update:");
        inventory.displayInventory();

        System.out.println("\nSorting by Name (Ascending):");
        inventory.sortByName(true);
        inventory.displayInventory();

        System.out.println("\nSorting by Price (Descending):");
        inventory.sortByPrice(false);
        inventory.displayInventory();

        System.out.println("\nRemoving Item ID 3");
        inventory.removeItemById(3);

        System.out.println("\nInventory after removal:");
        inventory.displayInventory();
    }
}
