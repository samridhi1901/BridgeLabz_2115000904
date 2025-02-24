import java.util.ArrayList;
import java.util.Scanner;

class WarningSuppressor {
    @SuppressWarnings("unchecked")
    void uncheckedListExample() {
        ArrayList list = new ArrayList();  
        list.add("Hello");
        list.add(100);
        list.add(3.14);

        System.out.println("List contents: " + list);
    }
}

public class WarningTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press Enter to see the unchecked list example...");
        scanner.nextLine();

        WarningSuppressor suppressor = new WarningSuppressor();
        suppressor.uncheckedListExample();

        scanner.close();
    }
}
