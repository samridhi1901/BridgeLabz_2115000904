import java.util.Scanner;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        return username.matches(regex);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        if (isValidUsername(username)) {
            System.out.println("Valid Username");
        } else {
            System.out.println("Invalid Username");
        }
        scanner.close();
    }
}
