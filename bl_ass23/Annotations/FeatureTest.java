import java.util.Scanner;

class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("This is an old feature. Avoid using it.");
    }

    void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

public class FeatureTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 1 for old feature, 2 for new feature: ");
        int choice = scanner.nextInt();

        LegacyAPI api = new LegacyAPI();

        if (choice == 1) {
            api.oldFeature();
        } else if (choice == 2) {
            api.newFeature();
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
