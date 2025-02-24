import java.util.Scanner;

class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class SoundTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press Enter to hear the dog sound...");
        scanner.nextLine();
        
        Dog dog = new Dog();
        dog.makeSound();

        scanner.close();
    }
}
