import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your name:");
        
        try {
            String name = reader.readLine();
            System.out.println("Enter your age:");
            String age = reader.readLine();
            System.out.println("Enter your favorite programming language:");
            String language = reader.readLine();
            
            FileWriter writer = new FileWriter("user_data.txt");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");
            writer.close();
            
            System.out.println("Information saved to user_data.txt");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
