// Superclass Vehicle
class Vehicle {
    String model;
    int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface Refuelable
interface Refuelable {
    void refuel();
}

// ElectricVehicle subclass
class ElectricVehicle extends Vehicle {
    int batteryCapacity; // in kWh

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(model + " is charging. Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// PetrolVehicle subclass implementing Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelCapacity; // in liters

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Fuel Capacity: " + fuelCapacity + " liters");
    }
}

public class VehicleSystem {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model 3", 200, 75);
        PetrolVehicle mustang = new PetrolVehicle("Ford Mustang", 250, 60);

        tesla.displayInfo();
        tesla.charge();
        System.out.println("----------------------");

        mustang.displayInfo();
        mustang.refuel();
    }
}
