import java.util.Scanner;

class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the temperature in Celsius:");
        int celsius = scanner.nextInt();
        
        int fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("The temperature in Fahrenheit is: " + fahrenheit);}}

