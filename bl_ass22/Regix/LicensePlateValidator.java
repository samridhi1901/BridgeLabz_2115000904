import java.util.Scanner;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a license plate number: ");
        String plate = scanner.nextLine();
        if (isValidLicensePlate(plate)) {
            System.out.println("Valid License Plate");
        } else {
            System.out.println("Invalid License Plate");
        }
        scanner.close();
    }
}
