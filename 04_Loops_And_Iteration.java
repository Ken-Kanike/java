/**
 * ==============================================================================
 * MODULE 04: LOOPS, LABELED BREAK & ITERATION
 * ==============================================================================
 * 
 * CORE CONCEPTS:
 * 1. for loop: Definite iteration.
 * 2. while loop: Entry-controlled indefinite iteration.
 * 3. do-while loop: Exit-controlled iteration (runs at least once).
 * 4. break and continue.
 * 5. Labeled break & continue for nested loops.
 */

class Loops_And_Iteration {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("1. Standard Loops (For, While, Do-While)");
        System.out.println("==================================================");

        // 1. For loop: counting sum of first 10 numbers
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Sum of 1 to 10: " + sum);

        // 2. While loop: binary conversion
        int n = 19;
        StringBuilder binary = new StringBuilder();
        int temp = n;
        while (temp > 0) {
            binary.insert(0, temp % 2);
            temp /= 2;
        }
        System.out.printf("Binary of %d is: %s%n", n, binary);

        // 3. Do-While loop: runs at least once
        int counter = 5;
        do {
            System.out.println("Do-while executed with counter = " + counter);
            counter++;
        } while (counter < 5);

        System.out.println("\n==================================================");
        System.out.println("2. Labeled Break & Continue in Nested Loops");
        System.out.println("==================================================");

        // Finding a target element in a 2D matrix and breaking out of both loops immediately
        int[][] matrix = {
            {1, 2, 3},
            {4, 99, 6},
            {7, 8, 9}
        };
        int target = 99;
        boolean found = false;

        searchLoop:
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == target) {
                    System.out.printf("Found %d at row %d, column %d!%n", target, row, col);
                    found = true;
                    break searchLoop; // Breaks outer loop immediately!
                }
            }
        }
        if (!found) System.out.println("Target not found.");
    }
}
