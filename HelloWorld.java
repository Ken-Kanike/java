/**
 * ==============================================================================
 * HELLO WORLD & JAVA PROGRAM STRUCTURE
 * ==============================================================================
 * 
 * Demonstrates:
 * 1. Standard Java application entry point (public static void main).
 * 2. Command-line arguments handling (String[] args).
 * 3. System.out.println standard output stream.
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("Welcome to Java Programming Mastery!");

        if (args.length > 0) {
            System.out.println("Command line arguments received:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("  arg[" + i + "]: " + args[i]);
            }
        }
    }
}
