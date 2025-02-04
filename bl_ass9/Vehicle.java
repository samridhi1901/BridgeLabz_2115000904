class Vehicle {
    private static double registrationFee = 500.0;
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Not a valid Vehicle object!");
        }
    }

    public static void main(String[] args) {
        Vehicle car = new Vehicle("Sam", "Car", "ABC123");
        Vehicle bike = new Vehicle("Anu", "Bike", "XYZ789");

        car.displayDetails();
        System.out.println();
        bike.displayDetails();

        System.out.println("\nUpdating Registration Fee...");
        Vehicle.updateRegistrationFee(600.0);

        System.out.println();
        car.displayDetails();
        System.out.println();
        bike.displayDetails();
    }
}
