import java.util.Scanner;

public class IPAddressValidator {
    public static boolean isValidIPAddress(String ip) {
        String regex = "\\b((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\b";
        return ip.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address: ");
        String ip = scanner.nextLine();
        if (isValidIPAddress(ip)) {
            System.out.println("Valid IP Address");
        } else {
            System.out.println("Invalid IP Address");
        }
        scanner.close();
    }
}
