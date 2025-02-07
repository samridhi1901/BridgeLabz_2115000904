// Superclass Person
class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

// Interface Worker
interface Worker {
    void performDuties();
}

// Chef subclass implementing Worker
class Chef extends Person implements Worker {
    String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is preparing dishes. Specialty: " + specialty);
    }
}

// Waiter subclass implementing Worker
class Waiter extends Person implements Worker {
    int tablesAssigned;

    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers at " + tablesAssigned + " tables.");
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("John Doe", 202, 5);

        chef.displayDetails();
        chef.performDuties();
        System.out.println("----------------------");

        waiter.displayDetails();
        waiter.performDuties();
    }
}
