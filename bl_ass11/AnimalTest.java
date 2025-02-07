class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String makeSound() {
        return "Some generic animal sound";
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeSound() {
        return "Woof! Woof!";
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeSound() {
        return "Meow! Meow!";
    }
}

class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeSound() {
        return "Chirp! Chirp!";
    }
}

public class AnimalTest {
    public static void main(String[] args) {
        Animal[] animals = {
            new Dog("Buddy", 3),
            new Cat("Whiskers", 2),
            new Bird("Tweety", 1)
        };

        for (Animal animal : animals) {
            System.out.println(animal.name + " says: " + animal.makeSound());
        }
    }
}
