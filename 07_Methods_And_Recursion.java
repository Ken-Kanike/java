/**
 * ==============================================================================
 * MODULE 07: METHODS, PASS-BY-VALUE & RECURSION
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. Method Definition, Return Types, and Formal Parameters.
 * 2. Pass-By-Value Semantics: Java is ALWAYS strictly pass-by-value (copies primitive values, copies object references).
 * 3. Variable Arguments (Varargs ...).
 * 4. Recursion: Base Case vs Recursive Step.
 * 5. Factorial and Fibonacci implementations.
 */

class Methods_And_Recursion {

    // 1. Pass-by-value demonstration
    public static void modifyPrimitive(int x) {
        x = 999; // Only modifies local copy
    }

    // 2. Varargs (Variable Arity Method)
    public static int calculateSum(int... values) {
        int total = 0;
        for (int v : values) {
            total += v;
        }
        return total;
    }

    // 3. Recursion: Factorial (n!)
    public static long factorial(int n) {
        if (n <= 1) return 1; // Base case
        return n * factorial(n - 1); // Recursive step
    }

    // 4. Recursion: Fibonacci Number (F(n))
    public static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("1. Pass-by-Value Verification");
        System.out.println("==================================================");
        int original = 50;
        modifyPrimitive(original);
        System.out.println("Original value after modifyPrimitive() call: " + original + " (Unchanged!)");

        System.out.println("\n==================================================");
        System.out.println("2. Varargs (Variable Argument List)");
        System.out.println("==================================================");
        System.out.println("Sum of (10, 20):         " + calculateSum(10, 20));
        System.out.println("Sum of (1, 2, 3, 4, 5):   " + calculateSum(1, 2, 3, 4, 5));

        System.out.println("\n==================================================");
        System.out.println("3. Recursive Algorithms (Factorial & Fibonacci)");
        System.out.println("==================================================");
        int factN = 6;
        System.out.printf("Factorial of %d! = %d%n", factN, factorial(factN));

        System.out.print("First 8 Fibonacci numbers: ");
        for (int i = 0; i < 8; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }
}
