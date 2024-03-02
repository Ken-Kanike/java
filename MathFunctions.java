import java.util.Scanner;
import java.lang.Math;

public class MathFunctions {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        double number = sc.nextDouble();
        
        // Square root
        System.out.println("Square root: " + Math.sqrt(number));
        
        // Absolute value
        System.out.println("Absolute value: " + Math.abs(number));
        
        // Sine
        System.out.println("Sine: " + Math.sin(number));
        
        // Cosine
        System.out.println("Cosine: " + Math.cos(number));
        
        // Logarithm (base 10)
        System.out.println("Logarithm (base 10): " + Math.log10(number));
        
        // Exponential
        System.out.println("Exponential: " + Math.exp(number));
        
        // Floor value
        System.out.println("Floor value: " + Math.floor(number));
        
        // Ceiling value
        System.out.println("Ceiling value: " + Math.ceil(number));
        
        // Rounded value
        System.out.println("Rounded value: " + Math.round(number));
        
        // Maximum value between the entered number and 10
        System.out.println("Maximum value: " + Math.max(number, 10));
        
        // Minimum value between the entered number and 5
        System.out.println("Minimum value: " + Math.min(number, 5));
        
        // Power of 2
        System.out.println("Power of 2: " + Math.pow(number, 2));
    }
}
